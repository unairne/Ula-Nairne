package com.kodilla.good.patterns.challenges.orderservice;

public class OrderDto {

    public User seller;
    public User buyer;
    public boolean isRented;

    public OrderDto(User seller, User buyer, boolean isRented) {
        this.seller = seller;
        this.buyer = buyer;
        this.isRented = isRented;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public boolean isRented() {
        return isRented;
    }
}