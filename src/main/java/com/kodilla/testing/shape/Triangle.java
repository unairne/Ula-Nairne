package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private int TriangleHeight;
    private int TriangleBase;
    private double TriangleField;

    public Triangle(int TriangleHeight, int TriangleBase) {
        this.TriangleHeight = TriangleHeight;
        this.TriangleBase = TriangleBase;
    }

    @Override
    public String getShapeName() {
        return (this.getClass().getSimpleName());
    }

    @Override
    public double getField() {
        TriangleField = (TriangleBase * TriangleHeight) / 2;
        return TriangleField;
    }

    public String toString() {
        return ((this.getClass().getSimpleName()) + " with field of " + TriangleField);
    }
}