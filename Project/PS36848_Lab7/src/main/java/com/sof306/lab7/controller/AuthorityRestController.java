package com.sof306.lab7.controller;

import com.sof306.lab7.dao.AccountDAO;
import com.sof306.lab7.dao.AuthorityDAO;
import com.sof306.lab7.dao.RoleDAO;
import com.sof306.lab7.entity.Authority;
import com.sof306.lab7.service.SecurityRestTemplate;
import com.sof306.lab7.service.SecurityRestUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthorityRestController {

    private final AccountDAO accountDAO;
    private final AuthorityDAO authorityDAO;
    private final RoleDAO roleDAO;

    @GetMapping("/rest/authorities")
    public Map<String, Object> getAuthorities() {
        Map<String, Object> data = new HashMap<>();
        data.put("authorities", authorityDAO.findAll());
        data.put("roles", roleDAO.findAll());
        data.put("accounts", accountDAO.findAll());
        return data;
    }

    @PostMapping("/rest/authorities")
    public Authority create(@RequestBody Authority authority) {
        return authorityDAO.save(authority);
    }

    @DeleteMapping("/rest/authorities/{id}")
    public void delete(@PathVariable int id) {
        authorityDAO.deleteById(id);
    }
}
