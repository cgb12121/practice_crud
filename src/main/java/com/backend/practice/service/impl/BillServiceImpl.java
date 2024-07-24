package com.backend.practice.service.impl;

import com.backend.practice.model.dto.BillDto;
import com.backend.practice.model.entity.bill.entity.Bill;
import com.backend.practice.repository.payment.BillRepository;
import com.backend.practice.service.BillService;
import com.backend.practice.util.mapper.BillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    private final BillMapper billMapper;

    @Override
    public List<BillDto> getAllBills() {
        return billRepository.findAll()
                .stream()
                .map(billMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BillDto> getBillById(Integer id) {
        return billRepository.findById(id)
                .map(billMapper::toDto);
    }

    @Override
    public BillDto createBill(BillDto billDto) {
        Bill bill = billMapper.toEntity(billDto);
        return billMapper.toDto(billRepository.save(bill));
    }

    @Override
    public BillDto updateBill(Integer id, BillDto billDto) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        billMapper.updateEntityFromDto(billDto, bill);
        return billMapper.toDto(billRepository.save(bill));
    }

    @Override
    public void deleteBill(Integer id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        billRepository.delete(bill);
    }
}
