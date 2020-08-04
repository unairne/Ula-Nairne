package com.kodilla.good.patterns.challenges.catering;

import com.kodilla.good.patterns.challenges.catering.main.MainOrderService;
import com.kodilla.good.patterns.challenges.catering.main.OrderRequest;
import com.kodilla.good.patterns.challenges.catering.main.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.catering.tasks.MainInformation;
import com.kodilla.good.patterns.challenges.catering.tasks.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.catering.tasks.ProductOrderService;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        List<OrderRequest> orderList = orderRequestRetriever.generateOrderList();

        MainOrderService mainOrderService = new MainOrderService(new MainInformation(), new ProductOrderService(), new ProductOrderRepository());

        for (OrderRequest order : orderList) {
            mainOrderService.process(order);
        }
    }
}
