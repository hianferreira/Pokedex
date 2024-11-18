package org.Pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonType extends Functions {

    public static class DamageRelations extends Functions{
        @SerializedName("double_damage_from")
        private List<TypeInfo> doubleDamageFrom;
        @SerializedName("double_damage_to")
        private List<TypeInfo> doubleDamageTo;
        @SerializedName("half_damage_from")
        private List<TypeInfo> halfDamageFrom;
        @SerializedName("half_damage_to")
        private List<TypeInfo> halfDamageTo;
        @SerializedName("no_damage_from")
        private List<TypeInfo> noDamageFrom;
        @SerializedName("no_damage_to")
        private List<TypeInfo> noDamageTo;

        public List<TypeInfo> getDoubleDamageFrom() {
            return doubleDamageFrom;
        }

        public List<TypeInfo> getDoubleDamageTo() {
            return doubleDamageTo;
        }

        public List<TypeInfo> getHalfDamageFrom() {
            return halfDamageFrom;
        }

        public List<TypeInfo> getHalfDamageTo() {
            return halfDamageTo;
        }

        public List<TypeInfo> getNoDamageFrom() {
            return noDamageFrom;
        }

        public List<TypeInfo> getNoDamageTo() {
            return noDamageTo;
        }

        @Override
        public String toString() {
            return "DamageRelations( " +
                    "doubleDamageFrom = " + doubleDamageFrom +
                    ", doubleDamageTo = " + doubleDamageTo +
                    ", halfDamageFrom = " + halfDamageFrom +
                    ", halfDamageTo = " + halfDamageTo +
                    ", noDamageFrom = " + noDamageFrom +
                    ", noDamageTo = " + noDamageTo +
                    " )";
        }
    }
    private String name;
    @SerializedName("damage_relations")
    private DamageRelations damageRelations;

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PokemonType( " +
                "name = " + name + '\'' +
                ", damageRelations=" + damageRelations +
                " )";
    }

    public static class TypeInfo extends Functions{
        private String name;

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name ;
        }
    }
}
