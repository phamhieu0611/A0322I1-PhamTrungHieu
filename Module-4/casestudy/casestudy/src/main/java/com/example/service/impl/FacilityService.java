package com.example.service.impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Page<Facility> searchFacility(String nameSearch, Pageable pageable) {
        return iFacilityRepository.searchFacility(nameSearch,pageable);
    }
    @Override
    public void deleteLogical(Integer id) {
        iFacilityRepository.deleteLogical(id);
    }

    @Override
    public Optional<Facility> findById(Integer integer) {
        return iFacilityRepository.findById(integer);
    }

    @Override
    public Page<Facility> searchFacility2(String nameSearch, String facilityTypeName, Pageable pageable) {
        return iFacilityRepository.searchFacility2(nameSearch,facilityTypeName,pageable);
    }
}
