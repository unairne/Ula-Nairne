package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public class ItemOrderService implements OrderService{

    @Override
    public boolean sell(User seller, User buyer, String itemName, LocalDateTime orderTime, double price) {
        System.out.println(seller.getUsername() + " sold his item: " + itemName + " for: " +
                buyer.getUsername() + ". Price: " + price + "zł Time: " + orderTime.toString());
        return true;
    }
}
