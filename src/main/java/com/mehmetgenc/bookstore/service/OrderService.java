package com.mehmetgenc.bookstore.service;

import com.mehmetgenc.bookstore.model.Book;
import com.mehmetgenc.bookstore.model.Order;
import com.mehmetgenc.bookstore.repository.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository orderRepository, BookService bookService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
    }

    public Order putAnOrder(List<Integer> bookIdList, String userName){
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());
        double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        return orderRepository.save(order);
    }
}
