package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String poem, PoemDecorator decorator) {

        String decoretedPoem = decorator.decorate(poem);
        System.out.println(decoretedPoem);
    }
}