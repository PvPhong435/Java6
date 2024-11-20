package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{

}
