package case_study.service;

import case_study.models.Contract;

public interface ContractService extends Service{
    void makeNewContract();
    void displayContract();
    void editContract();
}
