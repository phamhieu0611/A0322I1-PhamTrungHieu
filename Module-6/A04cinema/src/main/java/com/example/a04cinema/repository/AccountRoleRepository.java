package com.example.a04cinema.repository;

import com.example.a04cinema.entity.AccountRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRoles, Integer> {
}
