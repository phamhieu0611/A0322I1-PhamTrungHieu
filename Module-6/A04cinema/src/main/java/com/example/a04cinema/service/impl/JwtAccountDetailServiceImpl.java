package com.example.a04cinema.service.impl;

import com.example.a04cinema.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.a04cinema.repository.AccountRepository;

@Service
public class JwtAccountDetailServiceImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //check tài khoản có tồn tại không
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return JwtAccountDetailsImpl.build(account);
    }
}
