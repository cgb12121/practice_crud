package com.backend.practice.api.controller;

import com.backend.practice.model.dto.PaymentDto;
import com.backend.practice.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    @Operation(summary = "Get all payments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payments retrieved successfully")
    })
    public List<PaymentDto> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get payment by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<PaymentDto> getPaymentById(
            @Parameter(description = "Payment ID", required = true) @PathVariable Integer id) {
        Optional<PaymentDto> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<PaymentDto> createPayment(
            @Parameter(description = "Payment data", required = true) @RequestBody PaymentDto paymentDto) {
        PaymentDto createdPayment = paymentService.createPayment(paymentDto);
        return ResponseEntity.status(201).body(createdPayment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a payment by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment updated successfully"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<PaymentDto> updatePayment(
            @Parameter(description = "Payment ID", required = true) @PathVariable Integer id,
            @Parameter(description = "Updated payment data", required = true) @RequestBody PaymentDto paymentDto) {
        PaymentDto updatedPayment = paymentService.updatePayment(id, paymentDto);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a payment by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Payment deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    public ResponseEntity<Void> deletePayment(
            @Parameter(description = "Payment ID", required = true) @PathVariable Integer id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
