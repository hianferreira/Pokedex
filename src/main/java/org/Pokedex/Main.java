package org.Pokedex;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean sucess = false;
        int trys = 0;
        int maxTrys = 5;
        while (!sucess && trys < maxTrys) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Insert your pokemon : ");
                String urlPokemon = scanner.nextLine();
                // URL da API para a requisição GET
                String urlApi = "https://pokeapi.co/api/v2/pokemon/" + urlPokemon.toLowerCase();

                // Cria um cliente HttpClient
                HttpClient client = HttpClient.newHttpClient();

                // Cria a requisição GET
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(urlApi))
                        .GET()  // Define o método como GET
                        .build();

                // Envia a requisição e recebe a resposta
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                    String json = response.body();
                    System.out.println("Status Code: " + response.statusCode());

                    Gson gson = new Gson();

                    Pokemon pokemon = gson.fromJson(json, Pokemon.class);

                    System.out.println("Name: " + pokemon.firstLetterCaps(pokemon.getName()));
                    for (Pokemon.Type type : pokemon.getTypes()) {
                        if (type.getType().getTypeUrl() != null) {
                            HttpClient typeClient = HttpClient.newHttpClient();

                            HttpRequest TypeRequest = HttpRequest.newBuilder()
                                    .uri(new URI(type.getType().getTypeUrl()))
                                    .GET()
                                    .build();

                            HttpResponse<String> typeResponse = typeClient
                                    .send(TypeRequest, HttpResponse.BodyHandlers.ofString());

                            List<String> types = new ArrayList<>();
                            if (typeResponse.statusCode() == HttpURLConnection.HTTP_OK) {
                                Gson typeGson = new Gson();
                                String typeJson = typeResponse.body();
                                PokemonType pokemonType = typeGson.fromJson(typeJson, PokemonType.class);

                                String currentType = pokemonType.firstLetterCaps(pokemonType.getName());
                                String weakness = pokemonType.getDamageRelations().getDoubleDamageFrom().toString();

                                System.out.println("Type: " + currentType);
                                System.out.println("The type " + currentType + " is weak against " + weakness);

                                Functions exec = new Functions();
                                exec.writeJsonFile("pokedex", pokemon, pokemonType);

                            }
                        }
                    }
                    System.out.println("Height: " + pokemon.getHeightInMt() + "m");
                    System.out.println("Weight : " + pokemon.getWeightInKg() + "kg");

                    sucess = true;
                } else {
                    System.out.println("Erro na requisição: " + response.statusCode() + "\nNome de pokemon não listado, tente novamente");
                    trys++;
                }
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    }
}


