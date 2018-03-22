package com.laven.service;

import com.laven.dao.ItemRepository;
import com.laven.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Collection<Item> findAll(int type){
        return repository.findByEnable(true);
    }

    public Item getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        Item entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public Item update(Item entity){
        return repository.save(entity);
    }
    @Transactional
    public Item insert(Item entity) throws Exception {
        return repository.save(entity);
    }
}
