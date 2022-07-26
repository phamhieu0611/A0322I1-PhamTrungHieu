package case_study.service;

import case_study.models.Contract;

public interface BookingService {
    void makeNewContract(Contract contract);
    void displayContract();
    void editContract();
}
