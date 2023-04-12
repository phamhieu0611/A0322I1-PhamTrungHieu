package com.example.a04cinema.service.impl;

import com.example.a04cinema.repository.RoleRepository;
import com.example.a04cinema.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.a04cinema.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAllRole();
    }

    @Override
    public void setDefaultRole(String username, int roleId) {
        roleRepository.setDefaultRole(username, roleId);
    }
}
