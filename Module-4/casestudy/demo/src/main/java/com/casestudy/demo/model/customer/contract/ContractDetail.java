package com.casestudy.demo.model.customer.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private
}
