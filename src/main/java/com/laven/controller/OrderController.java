package com.laven.controller;

import com.laven.entity.Order;
import com.laven.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:48
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable("id") int id){
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOrderById(@PathVariable("id") int id){
        orderService.removeOrderById(id);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertOrder(@RequestBody Order order){
        orderService.insertOrder(order);
    }
}
