package com.example.service;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {

    List<Facility> findAll();

    void save(Facility facility);

    Page<Facility> searchFacility(String nameSearch, Pageable pageable);

    void deleteLogical( Integer id);

    Optional<Facility> findById(Integer integer);

    Page<Facility> searchFacility2(String nameSearch, String facilityTypeName,Pageable pageable);

}
