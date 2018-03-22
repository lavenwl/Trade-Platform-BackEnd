package com.laven.service;

import com.laven.dao.ProductRepository;
import com.laven.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Collection<Product> findAll(){
        return repository.findByEnable(true);
    }

    public Product getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        Product entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public Product update(Product entity){
        return repository.save(entity);
    }

    public Product insert(Product entity){
        Product e = entity;
        return repository.save(entity);
    }
}
