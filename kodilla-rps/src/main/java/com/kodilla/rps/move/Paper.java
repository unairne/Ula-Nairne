package com.kodilla.rps.move;

public class Paper implements RpsMove {
    private static Paper paperInstance = null;

    private Paper() {
    }

    public static Paper getInstance() {
        if (paperInstance == null) {
            paperInstance = new Paper();
        }
        return paperInstance;
    }
}