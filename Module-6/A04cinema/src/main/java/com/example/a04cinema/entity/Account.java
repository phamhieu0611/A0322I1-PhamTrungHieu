package com.example.a04cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private String username;
    @JsonIgnore
    private String password;

    private String isEnable;

    private String verificationCode;

    private Boolean isDelete;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<AccountRoles> accountRoleList;

    public Account() {
    }

    public Account(String username, String password, String isEnable, String verificationCode, Boolean isDelete, Set<AccountRoles> accountRoleList) {
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
        this.verificationCode = verificationCode;
        this.isDelete = isDelete;
        this.accountRoleList = accountRoleList;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
