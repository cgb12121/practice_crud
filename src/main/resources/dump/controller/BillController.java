//package com.backend.practice.util.dump.controller;
//
//import com.backend.practice.model.dto.BillDto;
//import com.backend.practice.service.BillService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/bills")
//public class BillController {
//
//    @Autowired
//    private BillService billService;
//
//    @GetMapping
//    @Operation(summary = "Get all bills")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Bills retrieved successfully")
//    })
//    public List<BillDto> getAllBills() {
//        return billService.getAllBills();
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Get bill by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Bill retrieved successfully"),
//            @ApiResponse(responseCode = "404", description = "Bill not found")
//    })
//    public ResponseEntity<BillDto> getBillById(
//            @Parameter(description = "Bill ID", required = true) @PathVariable Integer id) {
//        Optional<BillDto> bill = billService.getBillById(id);
//        return bill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    @Operation(summary = "Create a new bill")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Bill created successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<BillDto> createBill(
//            @Parameter(description = "Bill data", required = true) @RequestBody BillDto billDto) {
//        BillDto createdBill = billService.createBill(billDto);
//        return ResponseEntity.status(201).body(createdBill);
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Update a bill by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Bill updated successfully"),
//            @ApiResponse(responseCode = "404", description = "Bill not found")
//    })
//    public ResponseEntity<BillDto> updateBill(
//            @Parameter(description = "Bill ID", required = true) @PathVariable Integer id,
//            @Parameter(description = "Updated bill data", required = true) @RequestBody BillDto billDto) {
//        BillDto updatedBill = billService.updateBill(id, billDto);
//        return ResponseEntity.ok(updatedBill);
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete a bill by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Bill deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "Bill not found")
//    })
//    public ResponseEntity<Void> deleteBill(
//            @Parameter(description = "Bill ID", required = true) @PathVariable Integer id) {
//        billService.deleteBill(id);
//        return ResponseEntity.noContent().build();
//    }
//}
