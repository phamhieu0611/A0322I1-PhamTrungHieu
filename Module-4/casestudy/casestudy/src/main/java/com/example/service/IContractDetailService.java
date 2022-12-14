package com.example.service;

import com.example.model.contract.ContractDetail;

import java.util.List;
import java.util.Optional;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    Optional<ContractDetail> findById(Integer id);
}
