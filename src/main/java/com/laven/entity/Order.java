package com.laven.entity;

import java.util.List;
/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:52
 */
public class Order {
    private int id;
    private List<Item> itemList;
    private String desc;

    public Order(){}

    public Order(int id, List<Item> itemList, String desc) {
        this.id = id;
        this.itemList = itemList;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
