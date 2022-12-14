package com.example.service;

import com.example.model.Test;
import com.example.model.contract.ContractDetail;


import java.util.List;

public interface ICustomerRestService {

    List<ContractDetail> showAttach(int idSearch);
}
