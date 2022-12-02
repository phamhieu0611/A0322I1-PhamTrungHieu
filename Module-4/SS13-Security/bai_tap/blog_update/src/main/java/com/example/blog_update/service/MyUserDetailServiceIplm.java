package com.example.blog_update.service;

import com.example.blog_update.model.MyUserDetail;
import com.example.blog_update.model.User;
import com.example.blog_update.repository.UserRepositoory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyUserDetailServiceIplm implements UserDetailsService {
    @Autowired
    UserRepositoory userRepositoory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoory.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }
        return new MyUserDetail(user);
    }
}
