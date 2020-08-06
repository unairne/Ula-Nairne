package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private final Roll roll;
    private final Burger burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    static class BigmacBuilder {
        private Roll roll;
        private Burger burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            this.roll = new Roll(roll);
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = new Burger(burgers);
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = new Sauce(sauce);
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            this.ingredients.add(new Ingredient(ingredient));
            return this;
        }

        public BigMac build() {
            return new BigMac(roll, burgers, sauce, ingredients);
        }
    }

    private BigMac(Roll roll, Burger burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public Roll getRoll() {
        return roll;
    }

    public Burger getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "roll=" + roll.getRoll() +
                ", burgers=" + burgers.getQuantity() +
                ", sauce=" + sauce.getSauce() +
                ", ingredients=" + ingredients +
                '}';
    }
}