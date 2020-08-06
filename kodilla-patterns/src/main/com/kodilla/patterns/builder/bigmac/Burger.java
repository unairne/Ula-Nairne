package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;
import java.util.List;

public class Burger {

    private final static List<Integer> ACCEPTABLE_BURGERS = Arrays.asList(1, 2);
    private final int quantity;

    public Burger(int quantity) {
        if(ACCEPTABLE_BURGERS.contains(quantity)) {
            this.quantity = quantity;
        } else {
            throw new IllegalStateException("Quantity of burgers should be 1 or 2");
        }
    }