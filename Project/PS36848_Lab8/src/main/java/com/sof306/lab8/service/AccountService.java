package com.sof306.lab8.service;

import com.sof306.lab8.entity.Account;

public interface AccountService {

    /**
     * Finds an account by username
     *
     * @param username username
     * @return account with the specific username, or null if not found
     */
    Account findById(String username);

}
