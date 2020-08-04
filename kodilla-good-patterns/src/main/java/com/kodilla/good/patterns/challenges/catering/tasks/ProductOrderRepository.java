package com.kodilla.good.patterns.challenges.catering.tasks;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;
import com.kodilla.good.patterns.challenges.catering.tasks.OrderRepository;

public class ProductOrderRepository implements OrderRepository {

    @Override
    public boolean createOrder(Supplier supplier, String productName, double quantity) {
        return true;
    }
}
