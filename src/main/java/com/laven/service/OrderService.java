package com.laven.service;

import com.laven.dao.OrderRepository;
import com.laven.entity.Item;
import com.laven.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private StockService stockService;

    public Collection<Order> findAll(int type){
        return repository.findByEnableAndType(true, type);
    }

    public Order getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) throws Exception {
        // 获取订单进行验证是否具有可删除的条件
        Order entity = getById(id);
        Iterator<Item> it = entity.getItemList().iterator();
        while(it.hasNext()) {
            Item item = it.next();
            if (isPurchaseOrder(entity)) {
                stockService.reduce(item.getProductId(), item.getQuantity());
            } else if (isSaleOrder(entity)) {
                stockService.increase(item.getProductId(), item.getQuantity());
            }
            item.setEnable(false);
        }
        entity.setEnable(false);
        repository.save(entity);
    }

    /**
     * 修改订单(type=1:采购订单; type=0:销售订单)
     * @param entity
     * @return
     * @throws Exception
     */
    @Transactional
    public Order update(Order entity) throws Exception {
        // 处理库存逻辑
        Iterator<Item> it = entity.getItemList().iterator();
        while(it.hasNext()) {
            Item item = it.next();
            Item oldItem = itemService.getById(item.getId());
            double diffQauntity = item.getQuantity() - oldItem.getQuantity();
            if (isPurchaseOrder(entity)) {
                stockService.increase(item.getProductId(), diffQauntity);
            } else if (isSaleOrder(entity)) {
                stockService.reduce(item.getProductId(), diffQauntity);
            }
        }
        return repository.save(entity);
    }

    /**
     * 新增订单(type=1:采购订单; type=0:销售订单)
     * @param entity
     * @return
     * @throws Exception
     */
    @Transactional
    public Order insert(Order entity) throws Exception {
        // 处理库存逻辑
        Iterator<Item> it = entity.getItemList().iterator();
        while(it.hasNext()) {
            Item item = it.next();
            if (isPurchaseOrder(entity)) {
                stockService.increase(item.getProductId(), item.getQuantity());
            } else if (isSaleOrder(entity)) {
                stockService.reduce(item.getProductId(), item.getQuantity());
            }
        }
        return repository.save(entity);
    }

    /**
     * 判断订单是否为采购订单
     * @param order
     * @return
     */
    public boolean isPurchaseOrder(Order order) {
        return order.getType() == 1;
    }

    public boolean isSaleOrder(Order order) {
        return order.getType() == 0;
    }
}
