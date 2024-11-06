package org.Pokedex;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String pokemon = scanner.nextLine();

            // URL da API para a requisição GET
            String urlApi = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

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
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Resposta: " + response.body());

                // Cria um Gson com o padrão Camel Case
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

                String json = response.body();
                gson.fromJson(json, ApiPokedex.class);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApiPokedex pokedex = new ApiPokedex();
        System.out.println(pokedex.toString());
    }
}