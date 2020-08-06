package com.kodilla.patterns.builder.bigmac;

import java.util.Arrays;
import java.util.List;

public class Roll {

    private final static List<String> ACCEPTABLE_ROLLS = Arrays.asList("CLASSIC", "SESAME");
    private final String roll;

    public Roll(String roll) {
        if(ACCEPTABLE_ROLLS.contains(roll)) {
            this.roll = roll;
        } else {
            throw new IllegalStateException("Type of roll must be CLASSIC or SESAME");
        }
    }

    public String getRoll() {
        return roll;
    }
}
