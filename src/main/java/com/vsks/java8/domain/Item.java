package com.vsks.java8.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item /*implements Comparator<Item>*/ {

    private Long id;
    private String name;
    private String category;
    private Date creationDate;
    private Long quantity;

    public Item(Long id, String name, String category, Date creationDate, Long quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.creationDate = creationDate;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /*@Override
    public int compare(Item i1, Item i2) {
        if (!i1.getName().equals(i2.getName())) {
            return i1.getName().compareTo(i2.getName());
        }
        if (!i1.getCategory().equals(i2.getCategory())) {
            return i1.getCategory().compareTo(i2.getCategory());
        }
        if (!i1.getCreationDate().equals(i2.getCreationDate())) {
            return i1.getCreationDate().compareTo(i2.getCreationDate());
        }
        return 1;
    }*/

    public static String formatDate(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "[" + id + ", " + name + ", " + category + ", " + formatDate(creationDate, "dd-MM-yyyy") + ", " + quantity + "]";
    }
}
