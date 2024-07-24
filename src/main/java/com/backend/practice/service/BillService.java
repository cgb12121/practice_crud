package com.backend.practice.service;

import com.backend.practice.model.dto.BillDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BillService {
    List<BillDto> getAllBills();

    Optional<BillDto> getBillById(Integer id);

    BillDto createBill(BillDto billDto);

    BillDto updateBill(Integer id, BillDto billDto);

    void deleteBill(Integer id);
}
