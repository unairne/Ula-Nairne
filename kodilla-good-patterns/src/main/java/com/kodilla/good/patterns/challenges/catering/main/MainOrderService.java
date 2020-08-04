package com.kodilla.good.patterns.challenges.catering.main;

import com.kodilla.good.patterns.challenges.catering.tasks.InformationService;
import com.kodilla.good.patterns.challenges.catering.tasks.OrderRepository;
import com.kodilla.good.patterns.challenges.catering.tasks.OrderService;

public class MainOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public MainOrderService(final InformationService informationService,
                            final OrderService orderService,
                            final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.dispach(orderRequest.getSupplier(), orderRequest.getProductName(), orderRequest.getQuantity());
        if(isOrdered) {
            informationService.inform();
            orderRepository.createOrder(orderRequest.getSupplier(), orderRequest.getProductName(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getSupplier(), true);
        } else {
            return  new OrderDto(orderRequest.getSupplier(), false);
        }
    }
}
