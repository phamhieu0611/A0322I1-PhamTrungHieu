package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "select * from contract join customer on customer.id = contract.customer_id where customer.name_customer like %:nameCustomer% and contract.delete_status = 0",nativeQuery = true)
    Page<Contract> searchContract(@Param("nameCustomer") String nameCustomer, Pageable pageable);
}
