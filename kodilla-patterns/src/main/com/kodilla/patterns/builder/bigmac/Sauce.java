package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;
import java.util.List;

public class Sauce {

    private final static List<String> ACCEPTABLE_SAUCES = Arrays.asList("STANDARD", "THOUSAND ISLANDS", "BARBECUE");
    private final String sauce;

    public Sauce(String sauce) {
        if (ACCEPTABLE_SAUCES.contains(sauce)) {
            this.sauce = sauce;
        } else {
            throw new IllegalStateException("Sauce must be STANDARD, THOUSAND ISLANDS or BARBECUE");
        }
    }

    public String getSauce() {
        return sauce;
    }
}