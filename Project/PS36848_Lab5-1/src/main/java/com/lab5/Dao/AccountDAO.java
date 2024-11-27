package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String> {

}
