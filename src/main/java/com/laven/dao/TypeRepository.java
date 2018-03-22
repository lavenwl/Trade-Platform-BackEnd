package com.laven.dao;

import com.laven.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface TypeRepository extends JpaRepository<Type, Integer>{

    public List<Type> findByName(String name);

    public List<Type> findByEnable(boolean enable);
}
