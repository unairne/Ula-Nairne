package com.kodilla.good.patterns.challenges.catering.supplier;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;

import java.util.Random;

public class ExtraFoodShop implements Supplier {

    private Random random = new Random();

    @Override
    public boolean process() {

        int i = random.nextInt(10)+1;
        if (i <= 5) {
            System.out.println("Successful order from ExtraFoodShop!");
            return true;
        } else {
            System.out.println("Failed order from ExtraFoodShop \n");
            return false;
        }
    }
}