package com.vsks.thread.executor.service;

import com.vsks.java8.domain.Item;

import java.util.List;

public interface SellersService {

    List<Item> searchItem(String itemName);
}
