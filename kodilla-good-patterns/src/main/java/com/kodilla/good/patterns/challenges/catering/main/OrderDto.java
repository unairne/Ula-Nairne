package com.kodilla.good.patterns.challenges.catering.main;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;

public class OrderDto {

    private Supplier supplier;
    private boolean isOrdered;

    public OrderDto(Supplier supplier, boolean isOrdered) {
        this.supplier = supplier;
        this.isOrdered = isOrdered;
    }
}