package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public class ItemOrderRepository implements OrderRepository {

    @Override
    public boolean createOrder(User seller, User buyer, String itemName, LocalDateTime orderTime, double price) {
        return true;
    }
}