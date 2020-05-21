package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        System.out.println("The result is: " + a/b);
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide through zero! This ends error: " + e);
        } finally {
            System.out.println("End of program");
        }
    }
}