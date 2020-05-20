package com.kodilla.stream.beautifier;

public class FunctionalPoemDecorator {

    public static String addABCToFronAndEnd(String poem) {

        return "ABC "+ poem + "ABC";
    }

    public static String lowerCase(String poem) {

        return poem.toLowerCase();
    }

    public static String upperCase(String poem) {

        return poem.toUpperCase();
    }

    public static String replace(String poem) {

        return poem.replaceFirst("Tekst", "Jordan");
    }
}
