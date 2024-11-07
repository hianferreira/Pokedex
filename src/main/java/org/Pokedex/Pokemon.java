package org.Pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    private String name;
    private List<Type> types;
    private double height;
    private double weight;
    private String weakness;

    public List<Type> getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
    public double getWeightInKg(){
        return weight / 10;
    }
    public double getHeightInMt(){
        return height / 10;
    }


    public static class Type {
        private typeInfo type;

        public typeInfo getType() {
            return type;
        }

        public static class typeInfo {
            @SerializedName("name")
            private String typeName;
            @SerializedName("url")
            private String typeUrl;

            public String getTypeName() {
                return typeName;
            }

            public String getTypeUrl() {
                return typeUrl;
            }
        }
    }
}
