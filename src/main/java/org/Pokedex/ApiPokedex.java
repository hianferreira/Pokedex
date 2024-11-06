package org.Pokedex;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class ApiPokedex {
    private String name;
    private String type;
    private String height;
    private String weight;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "ApiPokedex{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
