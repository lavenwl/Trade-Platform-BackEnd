package com.laven.dao;

import com.laven.entity.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午11:09
 */
@Repository
@Qualifier("mysqlData")
public class MysqlOrderDaoImpl implements OrderDao {

    @Override
    public Collection<Order> getAllOrder() {
        return null;
    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public void removeOrderById(int id) {

    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void insertOrder(Order order) {

    }
}
