package com.example.a04cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String name;
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<AccountRoles> accountRoleList;

    private Boolean isDelete;

    public Role() {
    }

    public Role(Integer roleId, String name, Set<AccountRoles> accountRoleList, Boolean isDelete) {
        this.roleId = roleId;
        this.name = name;
        this.accountRoleList = accountRoleList;
        this.isDelete = isDelete;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AccountRoles> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(Set<AccountRoles> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
