package com.laven.controller;

import com.laven.entity.Company;
import com.laven.entity.Result;
import com.laven.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public Result<Collection<Company>> findAll(){
        return ResultUtil.success(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result<Company> getById(@PathVariable("id") int id){
        return ResultUtil.success(service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Company> deleteById(@PathVariable("id") int id){
        service.removeById(id);
        return ResultUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Company> update(@RequestBody @Valid Company entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.update(entity));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Company> insert(@RequestBody @Valid Company entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.insert(entity));
    }
}
