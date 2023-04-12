package com.example.a04cinema.repository;

import com.example.a04cinema.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select * from role", nativeQuery = true)
    List<Role> findAllRole();

    @Modifying
    @Query(value = "insert into account_roles(account_username,role_id) values (?1,?2)", nativeQuery = true)
    void setDefaultRole(String username, int roleId);
}
