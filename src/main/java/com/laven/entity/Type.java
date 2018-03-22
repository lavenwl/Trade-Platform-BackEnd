package com.laven.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/24 下午11:
 */
@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name="t_type")
public class Type {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "类型名称为必填项")
    private String name;
    private String note;
    private boolean enable = true;
    @UpdateTimestamp
    private Date updateTime;
    @CreationTimestamp
    private Date createTime;

    public Type() {
    }

    public Type(String name, String note) {
        this.name = name;
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
}
