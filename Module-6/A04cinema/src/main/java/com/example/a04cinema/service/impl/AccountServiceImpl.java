package com.example.a04cinema.service.impl;

import com.example.a04cinema.entity.Account;
import com.example.a04cinema.repository.AccountRepository;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.a04cinema.service.AccountService;

import java.io.UnsupportedEncodingException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public void addNew(String username, String password) throws MessagingException, UnsupportedEncodingException {
        accountRepository.addNew(username, password);
    }
}
