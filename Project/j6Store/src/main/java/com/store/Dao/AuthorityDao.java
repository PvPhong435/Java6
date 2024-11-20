package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Authority;

public interface AuthorityDao extends JpaRepository<Authority, String> {

}
