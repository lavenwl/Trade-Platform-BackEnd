package com.laven.controller;

import com.laven.entity.Result;
import com.laven.entity.Role;
import com.laven.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping
    public Result<Collection<Role>> findAll(){
        return ResultUtil.success(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result<Role> getById(@PathVariable("id") int id){
        return ResultUtil.success(service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Role> deleteById(@PathVariable("id") int id){
        service.removeById(id);
        return ResultUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Role> update(@RequestBody @Valid Role entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.update(entity));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Role> insert(@RequestBody @Valid Role entity, BindingResult bindingResult){
        /** 表单验证. */
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(service.insert(entity));
    }
}
