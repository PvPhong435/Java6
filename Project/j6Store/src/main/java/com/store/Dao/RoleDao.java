package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
