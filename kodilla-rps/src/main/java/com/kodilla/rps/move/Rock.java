package com.kodilla.rps.move;

public class Rock implements RpsMove {
    private static Rock rockInstance = null;

    private Rock() {
    }

    public static Rock getInstance() {
        if (rockInstance == null) {
            rockInstance = new Rock();
        }
        return rockInstance;
    }
}