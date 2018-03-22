package com.laven.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:52
 */
@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name="t_order")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    // 1:采购 0: 销售
    @NotNull(message = "订单类型为必填项")
    private int type;
    @ManyToOne()
    @JoinColumn(name = "purchaseId")
    @NotNull(message = "销售公司为必选项")
    private Company purchaseCompany;
    @ManyToOne()
    @JoinColumn(name = "saleId")
    @NotNull(message = "采购公司为必选项")
    private Company saleCompany;
    private double money;
    private String description;
    private boolean enable = true;
    @UpdateTimestamp
    private Date updateTime;
    @CreationTimestamp
    private Date createTime;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Set<Item> itemList;

    public Order(){}

    public Order(int id, int type, Company purchaseCompany, Company saleCompany, double money, Set<Item> itemList, String description) {
        this.id = id;
        this.type = type;
        this.purchaseCompany = purchaseCompany;
        this.saleCompany = saleCompany;
        this.money = money;
        this.description = description;
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Company getPurchaseCompany() {
        return purchaseCompany;
    }

    public void setPurchaseCompany(Company purchaseCompany) {
        this.purchaseCompany = purchaseCompany;
    }

    public Company getSaleCompany() {
        return saleCompany;
    }

    public void setSaleCompany(Company saleCompany) {
        this.saleCompany = saleCompany;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
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
