package com.example.a04cinema.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_roles")
public class AccountRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountRoleId;
    @ManyToOne
    @JoinColumn(name = "account_username")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Boolean isDelete;

    public AccountRoles() {
    }

    public AccountRoles(Integer accountRoleId, Account account, Role role, Boolean isDelete) {
        this.accountRoleId = accountRoleId;
        this.account = account;
        this.role = role;
        this.isDelete = isDelete;
    }

    public Integer getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
