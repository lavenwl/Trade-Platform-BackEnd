package com.laven.dao;

import com.laven.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{

    public List<Item> findByEnable(boolean enable);
}
