package com.kodilla.rps.move;

public class Scissors implements RpsMove {
    private static Scissors scissorsInstance = null;

    private Scissors() {
    }

    public static Scissors getInstance() {
        if (scissorsInstance == null) {
            scissorsInstance = new Scissors();
        }
        return scissorsInstance;
    }
}