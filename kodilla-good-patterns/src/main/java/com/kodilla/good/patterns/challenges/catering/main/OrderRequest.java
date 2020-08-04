package com.kodilla.good.patterns.challenges.catering.main;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;

public class OrderRequest {

    private Supplier supplier;
    private String productName;
    private double quantity;

    public OrderRequest(Supplier supplier, String productName, double quantity) {
        this.supplier = supplier;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getProductName() {
        return productName;
    }

    public double getQuantity() {
        return quantity;
    }
}