package com.laven.dao;

import com.laven.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface CompanyRepository extends JpaRepository<Company, Integer>{

    public List<Company> findByName(String name);

    public List<Company> findByEnable(boolean enable);
}
