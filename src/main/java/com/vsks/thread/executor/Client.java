package com.vsks.thread.executor;

import com.vsks.java8.domain.Item;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ItemSearchService itemSearchService = new ItemSearchService();
        List<Item> itemList = itemSearchService.searchItems("Wrist Watches for Men");
        System.out.println("Items: " + itemList);
    }
}
