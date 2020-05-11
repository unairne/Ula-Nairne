package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> myList = new ArrayList<>();

        //When
        ArrayList<Integer> resultList = oddNumbersExterminator.exterminate(myList);

        //Then
        Assert.assertEquals(0, resultList.size());

    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(1);
        myList2.add(22);
        myList2.add(45);
        myList2.add(3);

        //When
        ArrayList<Integer> resultList = oddNumbersExterminator.exterminate(myList2);

        //Then
        Assert.assertEquals(1, resultList.size());
    }
}