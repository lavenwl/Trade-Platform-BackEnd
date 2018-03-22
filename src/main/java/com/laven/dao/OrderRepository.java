package com.laven.dao;

import com.laven.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{

    public List<Order> findByEnable(boolean enable);

    public List<Order> findByEnableAndType(boolean enable, int type);
}
