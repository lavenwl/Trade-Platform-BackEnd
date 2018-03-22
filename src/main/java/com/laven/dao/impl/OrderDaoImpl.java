//package com.laven.dao.impl;
//
//import com.laven.dao.OrderDao;
//import com.laven.entity.Item;
//import com.laven.entity.Order;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
///**
// * @Description:
// * @Author: laven
// * @Date: 2017/7/1 下午11:58
// */
//@Repository
//@Qualifier("fakeData")
//public class OrderDaoImpl implements OrderDao {
//
//    private static Map<Integer, Order> orderMap;
//
//    static{
//        Item item1 = new Item(1,"红烧茄子",25,"茄子,酱油");
//        Item item2 = new Item(2,"青椒炒肉",30,"青椒,瘦肉,酱油");
//        Item item3 = new Item(3,"番茄炒蛋",15,"番茄,鸡蛋,酱油");
//        Item item4 = new Item(4,"红烧鸡块",20,"肌肉,鸡蛋,酱油");
//
//        List<Item> list1 = new ArrayList<Item>(){
//            {
//                add(item1);
//                add(item2);
//            }
//        };
//
//        List<Item> list2 = new ArrayList<Item>(){
//            {
//                add(item3);
//                add(item4);
//            }
//        };
//
//        orderMap = new HashMap<Integer, Order>(){
//            {
//                put(1, new Order(1, list1,"不加辣"));
//                put(2, new Order(2, list2,"不加酸"));
//            }
//        };
//    }
//
//    @Override
//    public Collection<Order> getAllOrder(){
//        return this.orderMap.values();
//    }
//
//    @Override
//    public Order getOrderById(int id){
//        return this.orderMap.get(id);
//    }
//
//    @Override
//    public void removeOrderById(int id) {
//        this.orderMap.remove(id);
//    }
//
//    @Override
//    public void updateOrder(Order order){
//        Order order2 = orderMap.get(order.getId());
//        order2.setItemList(order.getItemList());
//        order2.setDesc(order.getDesc());
//        orderMap.put(order.getId(),order2);
//    }
//
//    @Override
//    public void insertOrder(Order order){
//        orderMap.put(order.getId(), order);
//    }
//}
