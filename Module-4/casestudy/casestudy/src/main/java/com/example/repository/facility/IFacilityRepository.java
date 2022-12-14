package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select  * " +
            "from  facility" +
            " where" +
            " facility.name like %:nameSearch%" +
            " and " +
            "facility.delete_status = 0 ",
            nativeQuery = true)
    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch , Pageable pageable);


    @Query(value = "select * from  facility  join facility_type on facility_type.id = facility.facility_type_id where facility.name like %:nameSearch% and facility_type.name like %:facilityTypeName% and facility.delete_status = 0",nativeQuery = true)
    Page<Facility> searchFacility2(@Param("nameSearch") String nameSearch,
                                   @Param("facilityTypeName") String facilityTypeName,
                                   Pageable pageable);

    @Modifying
    @Query(value = "update facility set delete_status = 1 where id = :idDelete",nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);


}
