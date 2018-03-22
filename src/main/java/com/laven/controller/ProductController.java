package com.laven.controller;

import com.laven.entity.Product;
import com.laven.entity.Result;
import com.laven.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Result<Collection<Product>> findAll(){
        return ResultUtil.success(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result<Product> getById(@PathVariable("id") int id){
        return ResultUtil.success(service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Product> deleteById(@PathVariable("id") int id){
        service.removeById(id);
        return ResultUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Product> update(@RequestBody @Valid Product entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.update(entity));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Product> insert(@RequestBody @Valid Product entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.insert(entity));
    }
}
