package com.example.thuc_hanhphone.repository;

import com.example.thuc_hanhphone.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Integer> {
}
