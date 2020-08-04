package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User seller = new User("ulanairne");
        User buyer = new User("erwin");

        String itemName = "Laptop";
        LocalDateTime orderTime = LocalDateTime.of(2020,07,28,20,22);
        double price = 8700;

        return new OrderRequest(seller, buyer, itemName, orderTime, price);
    }
}
