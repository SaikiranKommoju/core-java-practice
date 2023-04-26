package com.vsks.thread.async;

import java.util.concurrent.CompletableFuture;

public class OrderDeliveryProcessor {

    private OrderService orderService = new OrderService();

    public void executeTasks() {
        for (Order order : orderService.getTodayDeliverables()) {
            CompletableFuture.supplyAsync(() -> orderService.assignOrder(order))
                    .thenAccept(o -> {
                        if ("DELIVERY_ASSIGNED".equalsIgnoreCase(o.getStatus())) {
                            orderService.sendDeliveryOtp(o);
                        }
                    });
        }
    }
}
