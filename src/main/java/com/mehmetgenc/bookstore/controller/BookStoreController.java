package com.mehmetgenc.bookstore.controller;

import com.mehmetgenc.bookstore.dto.BookOrderRequest;
import com.mehmetgenc.bookstore.model.Order;
import com.mehmetgenc.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {
    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Welcome to Book Store");
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAnOrder(
                bookOrderRequest.getBookIdList(),
                bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
