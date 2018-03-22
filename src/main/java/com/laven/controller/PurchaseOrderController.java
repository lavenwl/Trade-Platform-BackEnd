package com.laven.controller;

import com.laven.entity.Order;
import com.laven.entity.Result;
import com.laven.service.OrderService;
import com.laven.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:48
 */
@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public Result<Collection<Order>> findAll(){
        return ResultUtil.success(service.findAll(1));
    }

    @GetMapping(value = "/{id}")
    public Result<Order> getById(@PathVariable("id") int id){
        return ResultUtil.success(service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Order> deleteById(@PathVariable("id") int id) throws Exception {
        service.removeById(id);
        return ResultUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Order> update(@RequestBody @Valid Order entity, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.update(entity));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Order> insert(@RequestBody @Valid Order entity, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.insert(entity));
    }
}
