//package com.backend.practice.util.dump.controller;
//
//import com.backend.practice.model.dto.OrderDetailDto;
//import com.backend.practice.model.entity.bill.entity.OrderDetailId;
//import com.backend.practice.service.OrderDetailService;
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
//@RequestMapping("/api/order-details")
//public class OrderDetailController { // cart controller
//
//    @Autowired
//    private OrderDetailService orderDetailService;
//
//    @GetMapping
//    @Operation(summary = "Get all order details")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Order details retrieved successfully")
//    })
//    public List<OrderDetailDto> getAllOrderDetails() {
//        return orderDetailService.getAllOrderDetails();
//    }
//
//    @GetMapping("/{orderId}/{productId}")
//    @Operation(summary = "Get order detail by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Order detail retrieved successfully"),
//            @ApiResponse(responseCode = "404", description = "Order detail not found")
//    })
//    public ResponseEntity<OrderDetailDto> getOrderDetailById(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer orderId,
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer productId) {
//        OrderDetailId id = new OrderDetailId(orderId, productId);
//        Optional<OrderDetailDto> orderDetail = orderDetailService.getOrderDetailById(id);
//        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    @Operation(summary = "Create a new order detail")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Order detail created successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<OrderDetailDto> createOrderDetail(
//            @Parameter(description = "Order detail data", required = true) @RequestBody OrderDetailDto orderDetailDto) {
//        OrderDetailDto createdOrderDetail = orderDetailService.createOrderDetail(orderDetailDto);
//        return ResponseEntity.status(201).body(createdOrderDetail);
//    }
//
//    @PutMapping("/{orderId}/{productId}")
//    @Operation(summary = "Update an order detail by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Order detail updated successfully"),
//            @ApiResponse(responseCode = "404", description = "Order detail not found")
//    })
//    public ResponseEntity<OrderDetailDto> updateOrderDetail(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer orderId,
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer productId,
//            @Parameter(description = "Updated order detail data", required = true) @RequestBody OrderDetailDto orderDetailDto) {
//        OrderDetailId id = new OrderDetailId(orderId, productId);
//        OrderDetailDto updatedOrderDetail = orderDetailService.updateOrderDetail(id, orderDetailDto);
//        return ResponseEntity.ok(updatedOrderDetail);
//    }
//
//    @DeleteMapping("/{orderId}/{productId}")
//    @Operation(summary = "Delete an order detail by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Order detail deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "Order detail not found")
//    })
//    public ResponseEntity<Void> deleteOrderDetail(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer orderId,
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer productId) {
//        OrderDetailId id = new OrderDetailId(orderId, productId);
//        orderDetailService.deleteOrderDetail(id);
//        return ResponseEntity.noContent().build();
//    }
//}
