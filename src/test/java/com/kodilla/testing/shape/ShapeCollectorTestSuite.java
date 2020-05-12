package com.kodilla.testing.shape;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

    private static int testCount = 0;

    @BeforeClass
    public static void beforeAllTest() {
        System.out.println("Starting tests...");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("End of tests.");
    }

    @Before
    public void beforeEveryTest() {
        testCount++;
        System.out.println("Starting test number: " + testCount);
    }

    @Test
    public void testAddFigure() {
        //Given
        Circle circle = new Circle(3);
        ShapeCollector shapeCollector = new ShapeCollector(circle);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertTrue(shapeCollector.showFigures().contains(circle));
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Circle circle = new Circle(3);
        Square square = new Square(4);
        ShapeCollector shapeCollector = new ShapeCollector(circle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        //When
        shapeCollector.removeFigure(circle);
        //Then
        Assert.assertFalse(shapeCollector.showFigures().contains(circle));
        Assert.assertTrue(shapeCollector.showFigures().contains(square));
    }

    @Test
    public void testGetFigure() {

        //Given
        Circle circle = new Circle(3);
        ShapeCollector shapeCollector = new ShapeCollector(circle);
        shapeCollector.addFigure(circle);
        //When
        Shape figure = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(circle, figure);
    }

    @Test
    public void testShowFigures() {

        //Given
        Square square = new Square(10);
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(3,5);
        ShapeCollector shapeCollector = new ShapeCollector(square);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //When
        ArrayList<Shape> figures = shapeCollector.showFigures();
        //Then
        Assert.assertTrue(figures.contains(square));
        Assert.assertTrue(figures.contains(circle));
        Assert.assertTrue(figures.contains(triangle));
    }
}