package com.kodilla.stream.array;

import org.junit.*;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testGetAverage(){
        //Given
        int [] numbers = new int[] {2,5,1,4,3,2,7,9,5,2};
        //When
        double average = ArrayOperations.getAverage(numbers).getAsDouble();
        //Then
        Assert.assertEquals(4, average, 0.0000000001);
    }
}