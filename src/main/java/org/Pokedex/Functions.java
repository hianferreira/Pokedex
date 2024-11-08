package org.Pokedex;

public class Functions {

    public String firstLetterCaps(String word){
        if (word == null || word.isEmpty()){
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

    }
}
