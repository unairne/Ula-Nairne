package com.kodilla.good.patterns.challenges.orderservice;

public class ProductOrderService {

    private InformationService informationService;
    private OrderRepository orderRepository;
    private OrderService orderService;

    public ProductOrderService(final InformationService informationService,
                               final OrderRepository orderRepository,
                               final OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isSold = orderService.sell(orderRequest.getSeller(), orderRequest.getBuyer(), orderRequest.getItemName(),
                orderRequest.getOrderTime(), orderRequest.getPrice());
        if (isSold) {
            informationService.inform(orderRequest.getSeller());
            orderRepository.createOrder(orderRequest.getSeller(), orderRequest.getBuyer(), orderRequest.getItemName(),
                    orderRequest.getOrderTime(), orderRequest.getPrice());
            return new OrderDto(orderRequest.getSeller(), orderRequest.getBuyer(), true);
        } else {
            return new OrderDto(orderRequest.getSeller(), orderRequest.getBuyer(), false);
        }
    }
}