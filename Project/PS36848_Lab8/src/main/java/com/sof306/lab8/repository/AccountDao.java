package com.sof306.lab8.repository;

import com.sof306.lab8.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, String> {



}
