//package com.backend.practice.util.dump.controller;
//
//import com.backend.practice.model.dto.OrderDto;
//import com.backend.practice.service.OrderService;
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
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @GetMapping
//    @Operation(summary = "Get all orders")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Orders retrieved successfully")
//    })
//    public List<OrderDto> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Get order by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Order retrieved successfully"),
//            @ApiResponse(responseCode = "404", description = "Order not found")
//    })
//    public ResponseEntity<OrderDto> getOrderById(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer id) {
//        Optional<OrderDto> order = orderService.getOrderById(id);
//        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    @Operation(summary = "Create a new order")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Order created successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<OrderDto> createOrder(
//            @Parameter(description = "Order data", required = true) @RequestBody OrderDto orderDto) {
//        OrderDto createdOrder = orderService.createOrder(orderDto);
//        return ResponseEntity.status(201).body(createdOrder);
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Update an order by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Order updated successfully"),
//            @ApiResponse(responseCode = "404", description = "Order not found")
//    })
//    public ResponseEntity<OrderDto> updateOrder(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer id,
//            @Parameter(description = "Updated order data", required = true) @RequestBody OrderDto orderDto) {
//        OrderDto updatedOrder = orderService.updateOrder(id, orderDto);
//        return ResponseEntity.ok(updatedOrder);
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete an order by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "Order not found")
//    })
//    public ResponseEntity<Void> deleteOrder(
//            @Parameter(description = "Order ID", required = true) @PathVariable Integer id) {
//        orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
//}
