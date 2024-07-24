//package com.backend.practice.util.dump.service.impl;
//
//import com.backend.practice.model.dto.PaymentDto;
//import com.backend.practice.model.entity.bill.entity.Payment;
//import com.backend.practice.repository.payment.PaymentRepository;
//import com.backend.practice.util.dump.service.PaymentService;
//import com.backend.practice.util.mapper.PaymentMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Autowired
//    private PaymentMapper paymentMapper;
//
//    @Override
//    public List<PaymentDto> getAllPayments() {
//        return paymentRepository.findAll()
//                .stream()
//                .map(paymentMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<PaymentDto> getPaymentById(Integer id) {
//        return paymentRepository.findById(id)
//                .map(paymentMapper::toDto);
//    }
//
//    @Override
//    public PaymentDto createPayment(PaymentDto paymentDto) {
//        Payment payment = paymentMapper.toEntity(paymentDto);
//        return paymentMapper.toDto(paymentRepository.save(payment));
//    }
//
//    @Override
//    public PaymentDto updatePayment(Integer id, PaymentDto paymentDto) {
//        Payment payment = paymentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Payment not found"));
//        paymentMapper.updateEntityFromDto(paymentDto, payment);
//        return paymentMapper.toDto(paymentRepository.save(payment));
//    }
//
//    @Override
//    public void deletePayment(Integer id) {
//        Payment payment = paymentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Payment not found"));
//        paymentRepository.delete(payment);
//    }
//}
