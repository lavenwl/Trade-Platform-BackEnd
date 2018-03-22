package com.laven.controller;

import com.laven.entity.Result;
import com.laven.entity.Type;
import com.laven.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping
    public Result<Collection<Type>> findAll(){
        return ResultUtil.success(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result<Type> getById(@PathVariable("id") int id){
        return ResultUtil.success(service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Type> deleteById(@PathVariable("id") int id){
        service.removeById(id);
        return ResultUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Type> update(@RequestBody @Valid Type entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.update(entity));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Type> insert(@RequestBody @Valid Type entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.insert(entity));
    }
}
