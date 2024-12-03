package com.sof306.lab8.impl;

import com.sof306.lab8.entity.Account;
import com.sof306.lab8.repository.AccountDao;
import com.sof306.lab8.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    @Override
    public Account findById(String username) {
        Account account = accountDao.findById(username).orElse(null);
        if (account != null)
            account.getAuthorities().size();
        return account;
    }
}
