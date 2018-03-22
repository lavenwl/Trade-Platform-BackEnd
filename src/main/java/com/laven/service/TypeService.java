package com.laven.service;

import com.laven.dao.TypeRepository;
import com.laven.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public Collection<Type> findAll(){
        return repository.findByEnable(true);
    }

    public Type getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        Type entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public Type update(Type entity){
        return repository.save(entity);
    }

    public Type insert(Type entity){
        return repository.save(entity);
    }
}
