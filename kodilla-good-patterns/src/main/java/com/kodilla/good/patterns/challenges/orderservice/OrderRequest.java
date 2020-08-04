package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public class OrderRequest {

    public User seller;
    public User buyer;
    public String itemName;
    public LocalDateTime orderTime;
    public double price;

    public OrderRequest(User seller, User buyer, String itemName, LocalDateTime orderTime, double price) {
        this.seller = seller;
        this.buyer = buyer;
        this.itemName = itemName;
        this.orderTime = orderTime;
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public String getItemName() {
        return itemName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getPrice() {
        return price;
    }
}
