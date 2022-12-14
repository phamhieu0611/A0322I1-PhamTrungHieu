package com.example.repository.customer;

import com.example.model.Test;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRestRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select c.name_customer , atf.name_attach from customer  as c  " +
            "join contract as ct on ct.customer_id = c.id " +
            "join contract_detail as ctd on ctd.contract_id = ct.id " +
            "join where c.id =:idSearch",nativeQuery = true)
    List<ContractDetail> showAttach(@Param("idSearch") int idSearch);

    //nhiều chấm ra 1 , nhưng 1 không chấm ra được nhiều
}
