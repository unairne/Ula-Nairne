package com.kodilla.good.patterns.challenges.orderservice;

public class Application {
    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new PhoneService(),
                new ItemOrderRepository(), new ItemOrderService());
        productOrderService.process(orderRequest);
    }
}
