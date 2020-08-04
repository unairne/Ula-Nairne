package com.kodilla.good.patterns.challenges.catering.main;

import com.kodilla.good.patterns.challenges.catering.main.OrderRequest;
import com.kodilla.good.patterns.challenges.catering.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.catering.supplier.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.catering.supplier.HealthyShop;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public List<OrderRequest> generateOrderList() {

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();

        List<OrderRequest> ordersList = new ArrayList<>();

        ordersList.add(new OrderRequest(extraFoodShop, "meat balls", 300));
        ordersList.add(new OrderRequest(glutenFreeShop, "vegetable rolls", 200));
        ordersList.add(new OrderRequest(healthyShop, "mango slices",100));

        return ordersList;
    }


}
