package com.laven.service;

import com.laven.dao.OrderDao;
import com.laven.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class OrderService {

    @Autowired
    @Qualifier("fakeData")
    private OrderDao orderDao;

    public Collection<Order> getAllOrder(){
        return orderDao.getAllOrder();
    }

    public Order getOrderById(int id){
        return orderDao.getOrderById(id);
    }

    public void removeOrderById(int id) {
        orderDao.removeOrderById(id);
    }

    public void updateOrder(Order order){
        orderDao.updateOrder(order);
    }

    public void insertOrder(Order order){
        orderDao.insertOrder(order);
    }
}
