package com.kodilla.rps;

import com.kodilla.rps.move.Paper;
import com.kodilla.rps.move.Rock;
import com.kodilla.rps.move.RpsMove;
import com.kodilla.rps.move.Scissors;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class RpsGame {
    private static final String PLAYER = "Player";
    private static final String COMPUTER = "Computer";
    private static final String DRAW = "Draw";

    private static RpsGame rpsGameInstance = null;

    private final String playerName;
    private int winCondition = 0, playerPoints = 0, computerPoints = 0;
    private RpsMove playerLastMove = null, computerLastMove = null;
    private boolean isEnded = false, nextGame = false;

    private RpsGame(final String playerName) {
        this.playerName = playerName;
    }

    public static RpsGame initializeGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isVerified = false;
        if (rpsGameInstance == null) {
            while (!isVerified) {
                System.out.print("Enter your name: ");
                String name = scanner.next();
                isVerified = Pattern.matches("^[a-zA-Z]{2,}$", name);
                if (isVerified) {
                    rpsGameInstance = new RpsGame(name);
                } else {
                    System.out.println("Only letters are allowed (at least 2). Try again!");
                }
            }
        } else {
            rpsGameInstance.winCondition = 0;
            rpsGameInstance.playerPoints = 0;
            rpsGameInstance.computerPoints = 0;
            rpsGameInstance.playerLastMove = null;
            rpsGameInstance.computerLastMove = null;
            rpsGameInstance.isEnded = false;
            rpsGameInstance.nextGame = false;
        }
        isVerified = false;
        while (!isVerified) {
            System.out.print("Enter rounds to win: ");
            String rounds = scanner.next();
            isVerified = Pattern.matches("^[1-9]{1}[0-9]?$", rounds);
            if (isVerified) {
                rpsGameInstance.winCondition = Integer.valueOf(rounds);
            } else {
                System.out.println("Only numbers between 0 and 100 are allowed. Try again!");
            }
        }
        return rpsGameInstance;
    }

    public void displayInstruction() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!isEnded) {
            stringBuilder.append("How to play:\n")
                    .append("\tEnter '1' to choose ROCK\n")
                    .append("\tEnter '2' to choose PAPER\n")
                    .append("\tEnter '3' to choose SCISSORS\n");
        }
        stringBuilder.append("\tEnter 'x' to exit\n")
                .append("\tEnter 'n' to start new game");
        System.out.println(stringBuilder);
    }

    public boolean playGame() {
        while (!isEnded) {
            playerLastMove = makeMove(PLAYER);
            if (playerLastMove == null) {
                break;
            }
            computerLastMove = makeMove(COMPUTER);
            displayRoundSummary(checkRoundResult());
            checkIfGameEnds();
        }
        if (isEnded) {
            nextGame();
        }
        return nextGame;
    }

    private RpsMove makeMove(String player) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String move = "";
            boolean isVerified = false;
            switch (player) {
                case PLAYER:
                    playerLastMove = null;
                    while (!isVerified) {
                        System.out.print("Make your move: ");
                        move = scanner.next().substring(0, 1).toLowerCase();
                        isVerified = Pattern.matches("^[123xn]{1}$", move);
                        if (!isVerified) {
                            System.out.println("Only '1', '2', '3', 'x', 'n' are allowed. Try again!");
                        }
                    }
                    break;
                case COMPUTER:
                    computerLastMove = null;
                    move = String.valueOf(new Random().nextInt(3) + 1);
                    break;
            }
            switch (move) {
                case "1":
                    return Rock.getInstance();
                case "2":
                    return Paper.getInstance();
                case "3":
                    return Scissors.getInstance();
                case "x":
                    isVerified = false;
                    while (!isVerified) {
                        System.out.print("Confirm to exit [y/n]: ");
                        String yn = scanner.next().substring(0, 1).toLowerCase();
                        isVerified = Pattern.matches("^[yn]{1}$", yn);
                        if (isVerified) {
                            if (yn.equals("y")) {
                                nextGame = false;
                                return null;
                            }
                        } else {
                            System.out.println("Only 'y', 'n' are allowed. Try again!");
                        }
                    }
                    break;
                case "n":
                    isVerified = false;
                    while (!isVerified) {
                        System.out.print("Confirm to abort this game and start new one [y/n]: ");
                        String yn = scanner.next().substring(0, 1).toLowerCase();
                        isVerified = Pattern.matches("^[yn]{1}$", yn);
                        if (isVerified) {
                            if (yn.equals("y")) {
                                nextGame = true;
                                return null;
                            }
                        } else {
                            System.out.println("Only 'y', 'n' are allowed. Try again!");
                        }
                    }
                    break;
            }
        }
    }

    private String checkRoundResult() {
        String[][] points = {
                {Rock.class.getName(), Rock.class.getName(), "0", "0"},
                {Rock.class.getName(), Paper.class.getName(), "0", "1"},
                {Rock.class.getName(), Scissors.class.getName(), "1", "0"},
                {Paper.class.getName(), Rock.class.getName(), "1", "0"},
                {Paper.class.getName(), Paper.class.getName(), "0", "0"},
                {Paper.class.getName(), Scissors.class.getName(), "0", "1"},
                {Scissors.class.getName(), Rock.class.getName(), "0", "1"},
                {Scissors.class.getName(), Paper.class.getName(), "1", "0"},
                {Scissors.class.getName(), Scissors.class.getName(), "0", "0"}
        };
        for (String[] point: points) {
            if (point[0].equals(playerLastMove.getClass().getName()) && point[1].equals(computerLastMove.getClass().getName())) {
                if (point[2].equals(point[3])) {
                    return DRAW;
                } else {
                    if (point[2].equals("1")) {
                        playerPoints++;
                        return PLAYER;
                    } else {
                        computerPoints++;
                        return COMPUTER;
                    }
                }
            }
        }
        return "";
    }

    private void displayRoundSummary(String roundResult) {
        if (!roundResult.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Your move:\t\t").append(playerLastMove.getClass().getSimpleName()).append("\n")
                    .append("Computer move:\t").append(computerLastMove.getClass().getSimpleName()).append("\n")
                    .append("Round result:\t").append((roundResult.equals(PLAYER)) ? playerName : roundResult).append((roundResult.equals(PLAYER) || roundResult.equals(COMPUTER) ? " wins" : "")).append("\n")
                    .append("Current game result (").append(winCondition).append(" needed to win):\n")
                    .append("\t\t\t\t").append(PLAYER).append(" ").append(playerPoints).append(" : ").append(computerPoints).append(" ").append(COMPUTER);
            System.out.println(stringBuilder);
        }
    }

    private void checkIfGameEnds() {
        if (playerPoints == winCondition) {
            isEnded = true;
            System.out.println("The winner is " + playerName);
        } else if (computerPoints == winCondition) {
            isEnded = true;
            System.out.println("The winner is computer");
        }
    }

    private void nextGame() {
        displayInstruction();
        boolean isVerified = false;
        while (!isVerified) {
            System.out.print("Choose what to do: ");
            String choose = new Scanner(System.in).next().substring(0, 1).toLowerCase();
            isVerified = Pattern.matches("^[xn]{1}$", choose);
            if (isVerified) {
                nextGame = choose.equals("n");
            } else {
                System.out.println("Only 'x', 'n' are allowed. Try again!");
            }
        }
    }
}