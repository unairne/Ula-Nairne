package com.kodilla.testing.shape;

public class Square implements Shape {

    private int SquareSide;
    private double SquareField;

    public Square(int SquareSide) {
        this.SquareSide = SquareSide;
    }

    @Override
    public String getShapeName() {
        return (this.getClass().getSimpleName());
    }

    @Override
    public double getField() {
        SquareField = (SquareSide * SquareSide);
        return SquareField;
    }

    public String toString() {
        return ((this.getClass().getSimpleName()) + " with field of " + SquareField);
    }
}