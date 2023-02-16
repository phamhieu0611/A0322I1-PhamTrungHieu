package com.example.demo.model.loi;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contractId;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "customer_customerId")
    private Customer customer;
    private boolean contractType;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date contractTime;
    @Min(value = 500000, message = "Price least must be bigger than 500000")
    private double price;
    @Min(value = 20, message = "Area least must be bigger than 20 (m2)")
    private double area;

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isContractType() {
        return contractType;
    }

    public void setContractType(boolean contractType) {
        this.contractType = contractType;
    }

    public Date getContractTime() {
        return contractTime;
    }

    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
