package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;
import java.util.List;

public class Ingredient {

    private final static List<String> ACCEPTABLE_INGREDIENTS = Arrays.asList("LETTUCE", "ONION", "BACON", "CUCUMBER",
            "CHILLI PEPPER", "MUSHROOMS", "PRAWNS", "CHEESE");
    private final String ingredient;

    public Ingredient(String ingredient) {
        if (ACCEPTABLE_INGREDIENTS.contains(ingredient)) {
            this.ingredient = ingredient;
        } else {
            throw new IllegalStateException("Ingredient must be one of these: LETTUCE, ONION, BACON, CUCUMBER, " +
                    "CHILLI PEPPER, MUSHROOMS, PRAWNS, CHEESE");
        }
    }

    public String getIngredient() {
        return ingredient;
    }

    @Override
    public String toString() {
        return ingredient;
    }
}
