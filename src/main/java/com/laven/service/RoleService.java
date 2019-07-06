package com.laven.service;

import com.laven.dao.RoleRepository;
import com.laven.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Collection<Role> findAll(){
        return repository.findByEnable(true);
    }

    public Role getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        Role entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public Role update(Role entity){
        return repository.save(entity);
    }

    public Role insert(Role entity){
        return repository.save(entity);
    }
}
