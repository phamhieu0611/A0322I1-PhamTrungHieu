package com.example.repository.customer;

import com.example.model.contract.AttachFacility;
import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer join customer_type on customer.customer_type_id = customer_type.id " +
            "where customer.name_customer like %:nameSearch% " +
            "and customer.email like %:emailSearch% " +
            "and customer_type.name like %:customerType% " +
            "and customer.delete_status = 0", nativeQuery = true)
    Page<Customer> searchCustomer2(@Param("nameSearch") String nameSearch,
                                   @Param("emailSearch") String emailSearch,
                                   @Param("customerType") String customerType, Pageable pageable);

    @Query(value = "select  * " +
            "from  customer" +
            " where" +
            " customer.name like %:nameSearch%" +
            " and " +
            "customer.email like %:emailSearch%" +
            " and " +
            "customer.address like %:addressSearch%" +
            " and " +
            "customer.delete_status = 0 ",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch,
                                  @Param("emailSearch") String emailSearch,
                                  @Param("addressSearch") String addressSearch, Pageable pageable);

    @Modifying
    @Query(value = "update customer set delete_status = 1 where id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

    @Query(value = "select c.name_customer , atf.name_attach from customer  as c  " +
            "join contract as ct on ct.customer_id = c.id " +
            "join contract_detail as ctd on ctd.contract_id = ct.id " +
            "join attach_facility as atf on atf.id = ctd.attach_facility_id " +
            "where c.id =:idSearch",nativeQuery = true)
    List<AttachFacility> searchId(@Param("idSearch") int idSearch);


}
