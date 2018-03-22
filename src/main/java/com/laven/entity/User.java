package com.laven.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 *@Description: 
 *
 *@Params: No such property: code for class: Script1
 *@Author: laven
 *@Date: 2018/3/6 下午3:59
 */
@Entity
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "用户名称为必填项")
    private String name;
    @NotBlank(message = "密码为必填项")
    private String password;
    private String phone;
    @ManyToOne()
    @JoinColumn(name = "roleId")
    private Role role;
    @ManyToOne()
    @JoinColumn(name = "companyId")
    private Company company;
    private String note;
    private boolean enable = true;
    @UpdateTimestamp
    private Date updateTime;
    @CreationTimestamp
    private Date createTime;

    public User() {
    }

    public User(String name, String password, String phone, Role role, Company company, String note, boolean enable) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.company = company;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
