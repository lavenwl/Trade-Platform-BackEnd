package com.laven.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/24 下午11:
 */
@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "产品名称为必填项")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "typeId")
    private Type type;
    private String spec;
    private double priceIn;
    private double priceOut;
    private double stock;
    private String provider;
    private String factory;
    private String note;
    private boolean enable = true;
    @UpdateTimestamp
    private Date updateTime;
    @CreationTimestamp
    private Date createTime;

    public Product() {
    }

    public Product(String name, Type type, String spec, double priceIn, double priceOut, String provider, String factory, String note) {
        this.name = name;
        this.type = type;
        this.spec = spec;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.provider = provider;
        this.factory = factory;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
