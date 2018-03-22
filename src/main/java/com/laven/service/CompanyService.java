package com.laven.service;

import com.laven.dao.CompanyRepository;
import com.laven.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/2 上午10:09
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Collection<Company> findAll(){
        return repository.findByEnable(true);
    }

    public Company getById(int id){
        return repository.getOne(id);
    }

    public void removeById(int id) {
        Company entity = getById(id);
        entity.setEnable(false);
        repository.save(entity);
    }

    public Company update(Company entity){
        return repository.save(entity);
    }

    public Company insert(Company entity){
        return repository.save(entity);
    }
}
