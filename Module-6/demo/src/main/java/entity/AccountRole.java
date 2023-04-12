package entity;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleid;
    @ManyToOne
    @JoinColumn(name = "account_username")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Boolean isDelete;

    public AccountRole() {
    }

    public AccountRole(Integer roleid, Account account, Role role, Boolean isDelete) {
        this.roleid = roleid;
        this.account = account;
        this.role = role;
        this.isDelete = isDelete;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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
