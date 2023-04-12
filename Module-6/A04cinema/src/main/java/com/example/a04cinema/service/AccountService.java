package com.example.a04cinema.service;

import com.example.a04cinema.entity.Account;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

import java.io.UnsupportedEncodingException;

public interface AccountService {
    Account findAccountByUserName(String username);
    void addNew(String username, String password) throws MessagingException, UnsupportedEncodingException;
}
