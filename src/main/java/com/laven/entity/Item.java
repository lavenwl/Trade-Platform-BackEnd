package com.laven.entity;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:53
 */
public class Item {
    private int id;
    private String name;
    private double price;
    private String desc;

    public Item(){}

    public Item(int id, String name, double price, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
