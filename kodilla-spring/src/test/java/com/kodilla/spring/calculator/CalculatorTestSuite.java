package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double firstCalculation = calculator.add(2,4);
        double secondCalculation = calculator.sub(10,3);
        double thirdCalculation = calculator.mul(3,5);
        double fourthCalculation = calculator.div(8,2);
        //Then
        Assert.assertEquals(6,firstCalculation,0);
        Assert.assertEquals(7,secondCalculation,0);
        Assert.assertEquals(15,thirdCalculation,0);
        Assert.assertEquals(4,fourthCalculation,0);
    }
}