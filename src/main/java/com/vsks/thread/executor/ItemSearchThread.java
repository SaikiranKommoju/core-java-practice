package com.vsks.thread.executor;

import com.vsks.java8.domain.Item;
import com.vsks.thread.executor.service.SellersService;

import java.util.List;
import java.util.concurrent.Callable;

public class ItemSearchThread implements Callable<List<Item>> {

    private String itemName;
    private SellersService sellersService;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public SellersService getSellersService() {
        return sellersService;
    }

    public void setSellersService(SellersService sellersService) {
        this.sellersService = sellersService;
    }

    public ItemSearchThread(String itemName, SellersService sellersService) {
        this.itemName = itemName;
        this.sellersService = sellersService;
    }

    @Override
    public List<Item> call() throws Exception {
        return sellersService.searchItem(itemName);
    }
}
