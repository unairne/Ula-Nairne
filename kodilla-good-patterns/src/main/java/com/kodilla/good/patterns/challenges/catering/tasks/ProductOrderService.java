package com.kodilla.good.patterns.challenges.catering.tasks;

import com.kodilla.good.patterns.challenges.catering.supplier.Supplier;
import com.kodilla.good.patterns.challenges.catering.tasks.OrderService;

public class ProductOrderService implements OrderService {

    @Override
    public boolean dispach(Supplier supplier, String productName, double quantity) {
        if (supplier.process()) {
            System.out.println("Order details:" +
                    "\nProduct name: " + productName +
                    "\nQuantity: " + quantity);
            return true;
        } else {
            return false;
        }
    }
}
