package com.laven.dao;

import com.laven.entity.Order;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午11:08
 */
public interface OrderDao {
    Collection<Order> getAllOrder();

    Order getOrderById(int id);

    void removeOrderById(int id);

    void updateOrder(Order order);

    void insertOrder(Order order);
}
