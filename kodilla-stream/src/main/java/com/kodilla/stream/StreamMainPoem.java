package com.kodilla.stream;

import com.kodilla.stream.beautifier.FunctionalPoemDecorator;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMainPoem {
    public static void main(String[] args) {
        System.out.println("Poem Beautify with Lambda");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String poem = "Tekst tekst tekst";
        poemBeautifier.beautify(poem, stringToDecorate -> "abc" + stringToDecorate + "cba");
        poemBeautifier.beautify(poem, String::toUpperCase);
        poemBeautifier.beautify(poem, String::toLowerCase);
        poemBeautifier.beautify(poem, stringToDecorate -> stringToDecorate.replaceFirst("Tekst", "null"));
        System.out.println("----------------------------------------------");

        System.out.println("Poem Beautify with Reference");
        poemBeautifier.beautify(poem, FunctionalPoemDecorator::addABCToFronAndEnd);
        poemBeautifier.beautify(poem, FunctionalPoemDecorator::upperCase);
        poemBeautifier.beautify(poem, FunctionalPoemDecorator::lowerCase);
        poemBeautifier.beautify(poem, FunctionalPoemDecorator::replace);

    }
}
