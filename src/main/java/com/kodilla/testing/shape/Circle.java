package com.kodilla.testing.shape;

public class Circle implements Shape {

    private int Radius;
    private final double Pi = 3.14;
    private double CircleField;

    public Circle(int Radius){
        this.Radius = Radius;
    }

    @Override
    public String getShapeName() {
        return (this.getClass().getSimpleName());
    }

    @Override
    public double getField() {
        CircleField = Pi * (Radius * Radius);
        return CircleField;
    }

    public String toString(){
        return (this.getClass().getSimpleName()) + " with field of " + CircleField;
    }
}
