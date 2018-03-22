package com.laven.dao;

import com.laven.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

    public List<Product> findByName(String name);

    public List<Product> findByEnable(boolean enable);
}
