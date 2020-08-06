package com.kodilla.patterns.builder.bigmac;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BigmacTestSuite {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private BigMac bigMac;

    @Test
    public void testMyOwnBigmac() {
        //Given
        bigMac = new BigMac.BigmacBuilder()
                .roll("SESAME")
                .burgers(2)
                .sauce("BARBECUE")
                .ingredient("ONION")
                .ingredient("BACON")
                .ingredient("CUCUMBER")
                .ingredient("CHEESE")
                .build();
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        Burger burgersQuantity = bigMac.getBurgers();
        Roll rollType = bigMac.getRoll();
        Sauce sauceType = bigMac.getSauce();
        //Then
        System.out.println(bigMac);
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals(2, burgersQuantity.getQuantity());
        Assert.assertEquals("SESAME", rollType.getRoll());
        Assert.assertEquals("BARBECUE", sauceType.getSauce());
    }

    @Test(expected = IllegalStateException.class)
    public void testExceptionFirstMethod() {
        bigMac = new BigMac.BigmacBuilder()
                .roll("CLASSIC")
                .burgers(3)
                .sauce("KETCHUP")
                .ingredient("TOMATO")
                .build();
    }

    @Test
    public void testExceptionSecondMethod() {
        //Given
        try {
            bigMac = new BigMac.BigmacBuilder()
                    .roll("CLASSIC")
                    .burgers(2)
                    .sauce("KETCHUP")
                    .ingredient("ONION")
                    .build();
            fail("Should throw an exception if one or moge of given values are not contained in Lists");
        } catch (Exception e) {
            assertThat(e, IsInstanceOf.instanceOf(IllegalStateException.class));
            assertEquals("Sauce must be STANDARD, THOUSAND ISLANDS or BARBECUE", e.getMessage());
        }
    }

    @Test
    public void testExceptionThirdMethod() {
        //arrange
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Type of roll must be CLASSIC or SESAME");
        //act
        bigMac = new BigMac.BigmacBuilder()
                .roll("SPICY")
                .burgers(1)
                .sauce("BARBECUE")
                .ingredient("ONION")
                .build();
    }

}