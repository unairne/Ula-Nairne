package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean nextGame = true;
        while (nextGame) {
            RpsGame game = RpsGame.initializeGame();
            game.displayInstruction();
            nextGame = game.playGame();
        }
    }
}