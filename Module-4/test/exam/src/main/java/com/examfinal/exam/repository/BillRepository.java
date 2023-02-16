package com.examfinal.exam.repository;

import com.examfinal.exam.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    Page<Bill> findBillByPublishDateAfter(Pageable pageable, Date searchVal);

    Page<Bill> findBillByPublishDateBetween(Pageable pageable, Date searchVal, Date searchVal2);

    Page<Bill> findBillByPublishDateAfterAndPublishDateBefore(Pageable pageable, Date searchVal, Date searchVal2);
}
