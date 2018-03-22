package com.laven.service;

import com.laven.dao.UserRepository;
import com.laven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Collection<User> findAll(){
        return repository.findByEnable(true);
    }

    public User getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        User entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public User update(User entity){
        return repository.save(entity);
    }

    public User insert(User entity){
        User e = entity;
        return repository.save(entity);
    }
}
