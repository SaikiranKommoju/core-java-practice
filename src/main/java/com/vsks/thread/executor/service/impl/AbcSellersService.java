package com.vsks.thread.executor.service.impl;

import com.vsks.java8.domain.Item;
import com.vsks.thread.executor.service.SellersService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AbcSellersService implements SellersService {

    @Override
    public List<Item> searchItem(String itemName) {
        System.out.println("Searching for " + itemName + " in ABC Sellers");
        return Arrays.asList(new Item(1L, "Fastrack", "Wrist Watch", prepareDate(2023, 0, 1), 1L, "ABC Sellers"),
                new Item(2L, "Sonata", "Wrist Watch", prepareDate(2023, 1, 1), 2L, "ABC Sellers"));
    }

    private static Date prepareDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
}
