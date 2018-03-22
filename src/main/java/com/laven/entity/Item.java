package com.laven.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:53
 */
@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name="t_item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private int num;
    private int productId;
    private double quantity;
    private double price;
    private double money;
    private String description;
    private boolean enable = true;
    @UpdateTimestamp
    private Date updateTime;
    @CreationTimestamp
    private Date createTime;

    public Item(){}

    public Item(int num, double quantity, double price, double money, String description) {
        this.num = num;
        this.quantity = quantity;
        this.price = price;
        this.money = money;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
