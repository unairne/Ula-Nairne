package com.kodilla.good.patterns.challenges.catering.tasks;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;

public interface OrderRepository {

    boolean createOrder(Supplier supplier, String productName, double quantity);
}
