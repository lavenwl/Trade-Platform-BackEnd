package com.laven.dao;

import com.laven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByName(String name);

    public List<User> findByEnable(boolean enable);
}
