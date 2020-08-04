package com.kodilla.good.patterns.challenges.orderservice;

import java.time.LocalDateTime;

public interface OrderService {

    boolean sell(User seller, User buyer, String itemName, LocalDateTime orderTime, double price);
}