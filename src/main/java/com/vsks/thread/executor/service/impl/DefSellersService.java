package com.vsks.thread.executor.service.impl;

import com.vsks.java8.domain.Item;
import com.vsks.thread.executor.service.SellersService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DefSellersService implements SellersService {

    @Override
    public List<Item> searchItem(String itemName) {
        System.out.println("Searching for " + itemName + " in DEF Sellers");
        sleep(5000L);
        return Arrays.asList(new Item(3L, "Fastrack", "Wrist Watch", prepareDate(2023, 0, 1), 1L, "DEF Sellers"),
                new Item(4L, "Titan", "Wrist Watch", prepareDate(2023, 1, 1), 2L, "DEF Sellers"));
    }

    private static Date prepareDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
