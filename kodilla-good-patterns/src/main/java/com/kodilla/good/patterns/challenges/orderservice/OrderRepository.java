package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public interface OrderRepository {

    boolean createOrder(User seller, User buyer, String itemName, LocalDateTime orderTime, double price);
}