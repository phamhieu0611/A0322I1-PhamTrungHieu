package com.example.a04cinema.service;

import com.example.a04cinema.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    void setDefaultRole(String username, int roleId);
}
