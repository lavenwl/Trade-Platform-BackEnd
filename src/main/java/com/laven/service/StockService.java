package com.laven.service;

import com.laven.entity.Product;
import com.laven.enums.ResultEnum;
import com.laven.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 库存逻辑处理逻辑类
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class StockService {

    @Autowired
    private ProductService productService;
    @Autowired
    private ItemService itemService;

    /**
     * 根据产品ID新增库存
     * @param productId 产品ID
     * @param quantity 新增库存数量
     */
    public void increase(int productId, double quantity) {
        double setQuantity = getStock(productId) + quantity;
        if(setQuantity < 0) {
            throw new MyException(ResultEnum.LOW_STOCKS);
        }
        setStock(productId, setQuantity);
    }

    /**
     * 根据产品ID减少库存
     * @param productId     产品ID
     * @param quantity      减少库存数量
     * @throws Exception    库存不足
     */
    public void reduce(int productId, double quantity) throws Exception {
        double setQuantity = getStock(productId) - quantity;
        if(setQuantity < 0) {
            throw new MyException(ResultEnum.LOW_STOCKS);
        }
        setStock(productId, setQuantity);
    }

    /**
     * 根据产品ID获取产品的库存量
     * @param productId
     * @return
     */
    public double getStock(int productId) {
        return productService.getById(productId).getStock();
    }

    /**
     * 根据产品ID设置库存
     * @param productId     产品ID
     * @param quantity      设置库存数量
     */
    public void setStock(int productId, double quantity) {
        Product product = productService.getById(productId);
        product.setStock(quantity);
        productService.update(product);
    }

//    /**
//     * 正向更新(采购订单的更新操作)
//     * 如果item数量由5-->10则数据库操作:库存+5
//     * @param itemList
//     */
//    public void positiveUpdateList(Set<Item> itemList) throws Exception {
//        Iterator<Item> it = itemList.iterator();
//        while(it.hasNext()) {
//            Item item = it.next();
//            positiveUpdate(item);
//        }
//
//    }
//
//    private void positiveUpdate(Item item) throws Exception {
//        Item oldItem = itemService.getById(item.getId());
//        double addStockNum = item.getQuantity() - oldItem.getQuantity();
//        Product product = productService.getById(item.getProductId());
//        if ((product.getStock() + addStockNum) < 0) {
//            throw new MyException(ResultEnum.LOW_STOCKS);
//        }
//        product.setStock(product.getStock() + addStockNum);
//    }
//
//    /**
//     * 反向更新(销售订单的更新操作)
//     * 如果item数量由5-->10则数据库操作:库存-5
//     * @param itemList
//     */
//    public void negativeUpdateList(Set<Item> itemList) throws Exception {
//        Iterator<Item> it = itemList.iterator();
//        while(it.hasNext()) {
//            Item item = it.next();
//            negativeUpdate(item);
//        }
//    }
//
//    private void negativeUpdate(Item item) throws Exception {
//        Item oldItem = itemService.getById(item.getId());
//        double reduceStockNum = item.getQuantity() - oldItem.getQuantity();
//        Product product = productService.getById(item.getProductId());
//        if ((product.getStock() - reduceStockNum) < 0) {
//            throw new MyException(ResultEnum.LOW_STOCKS);
//        }
//        product.setStock(product.getStock() - reduceStockNum);
//    }
}
