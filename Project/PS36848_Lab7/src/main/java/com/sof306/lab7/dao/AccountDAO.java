package com.sof306.lab7.dao;

import com.sof306.lab7.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {


}
