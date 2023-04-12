package com.example.a04cinema.repository;

import com.example.a04cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String username);

    @Modifying
    @Query(value = "insert into account(username,password) values (?1,?2)", nativeQuery = true)
    void addNew(String username, String password);

    @Modifying
    @Query(value ="update account set verification_code=?1 where username =?2",nativeQuery = true)
    void addVerificationCode(String code,String username);

    @Query(value = "select * from account where verification_code =?1",nativeQuery = true)
    Account findAccountByVerificationCode(String verifyCode);

    @Modifying
    @Query(value = "update account set password =?1,verification_code=null where verification_code=?2",nativeQuery = true)
    void saveNewPassword(String password, String code);

    @Query(value = "SELECT email FROM account where email= ?1", nativeQuery = true)
    String existsByEmail(String email);
}
