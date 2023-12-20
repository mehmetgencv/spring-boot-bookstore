package com.mehmetgenc.bookstore.repository;

import com.mehmetgenc.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
