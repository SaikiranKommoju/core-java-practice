package com.vsks.java8.stream;

import com.vsks.java8.domain.Item;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample2 {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1L, "Lloyd", "AC", prepareDate(2023, 0, 1), 1L),
                new Item(2L, "LG", "Washing Machine", prepareDate(2023, 1, 1), 2L),
                new Item(3L, "Bluestar", "AC", prepareDate(2023, 1, 1), 3L),
                new Item(4L, "LG", "Washing Machine", prepareDate(2023, 0, 1), 4L)
        );
        System.out.println("Before: " + items);

        Map<String, Long> nameItem = items.stream()
                .collect(Collectors.toMap(Item::getName, Item::getQuantity)); // throws exception bcoz items contains duplicate names

        Map<String, Long> itemQuantity = items.stream()
                .filter(it -> Objects.nonNull(it.getName()) && Objects.nonNull(it.getQuantity()) && it.getQuantity().compareTo(0L) > 0)
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingLong(Item::getQuantity)));
        System.out.println("Item-Quantity: " + itemQuantity);

        items.sort((i1, i2) -> {
            if (!i1.getName().equalsIgnoreCase(i2.getName())) {
                return i1.getName().compareTo(i2.getName());
            }
            if (!i1.getCategory().equalsIgnoreCase(i2.getCategory())) {
                return i1.getCategory().compareTo(i2.getCategory());
            }
            if (!i1.getCreationDate().equals(i2.getCreationDate())) {
                return i1.getCreationDate().compareTo(i2.getCreationDate());
            }
            return 1;
        });
        System.out.println("After: " + items);

        List<Item> sortedItems = items.stream()
                .sorted(Comparator.comparing(Item::getName).thenComparing(Item::getCategory).thenComparing(Item::getCreationDate))
                .collect(Collectors.toList());
        System.out.println(sortedItems);

        Map<String, Long> itemCount = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println("Item-Count: " + itemCount);
    }

    private static Date prepareDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
}
