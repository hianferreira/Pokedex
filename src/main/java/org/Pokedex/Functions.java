package org.Pokedex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Functions {

    public String firstLetterCaps(String word){
        if (word == null || word.isEmpty()){
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    public void writeJsonFile(String name, Pokemon pokemon, PokemonType pokemonType ) {
        try (FileWriter e = new FileWriter(name+".json")){

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Object[] jsonArray = {pokemon,pokemonType};
            gson.toJson(jsonArray, e);

        }catch (IOException e ){
            System.out.println(e);
        }
    }
}

