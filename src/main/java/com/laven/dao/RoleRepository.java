package com.laven.dao;

import com.laven.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/2/25 上午11:54
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

    public List<Role> findByName(String name);

    public List<Role> findByEnable(boolean enable);
}
