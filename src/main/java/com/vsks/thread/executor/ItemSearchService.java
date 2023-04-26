package com.vsks.thread.executor;

import com.vsks.java8.domain.Item;
import com.vsks.thread.executor.service.impl.AbcSellersService;
import com.vsks.thread.executor.service.impl.DefSellersService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ItemSearchService {

    public List<Item> searchItems(String itemName) throws ExecutionException, InterruptedException {
        List<Item> items = new ArrayList<>();

        List<ItemSearchThread> itemSearchThreads = getItemSearchThreads(itemName);

        String sellers = itemSearchThreads.stream()
                .map(it -> it.getSellersService().getClass().getSimpleName().split("Service")[0])
                .collect(Collectors.joining(","));

        System.out.println("Searching for " + itemName + " in " + sellers);

        ExecutorService executorService = Executors.newFixedThreadPool(itemSearchThreads.size());

        List<Future<List<Item>>> futureList = new ArrayList<>();
        for (ItemSearchThread itemSearchThread : itemSearchThreads) {
            Future<List<Item>> futureData = executorService.submit(itemSearchThread); // This call submits the task and gives the Future which is an output placeholder. It may not contain the output immediately because the task completion may take time (IO tasks). Whenever the task is finished, Future will be updated with it.
            futureList.add(futureData);
        }

        System.out.println("Before shutting down the Executor service");

        executorService.shutdown();// Won't accept new tasks and executes the previously submitted tasks

        System.out.println("After shutting down the Executor service");

        while (!executorService.isTerminated()) {
        }

        for (Future<List<Item>> future : futureList) {
            items.addAll(future.get()); // Blocks the main thread till the task is finished, it just doesn't care even if other tasks are completed
        }

        return items;
    }

    private List<ItemSearchThread> getItemSearchThreads(String itemName) {
        return Arrays.asList(new ItemSearchThread(itemName, new AbcSellersService()),
                new ItemSearchThread(itemName, new DefSellersService()));
    }
}
