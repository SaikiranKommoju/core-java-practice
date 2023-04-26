package com.vsks.thread.async;

import java.util.Arrays;
import java.util.List;

public class OrderService {

    public List<Order> getTodayDeliverables() {
        return Arrays.asList(new Order(), new Order());
    }

    public Order assignOrder(Order order) {
        System.out.println("Assigning order to delivery agent ...");
        order.setStatus("DELIVERY_ASSIGNED");
        return order;
    }

    public void sendDeliveryOtp(Order order) {
        System.out.println("Sending verification OTP to mobile via SMS to " + order.getMobileNo() + " ...");
    }
}
