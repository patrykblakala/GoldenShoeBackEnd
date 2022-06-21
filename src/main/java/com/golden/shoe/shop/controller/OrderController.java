package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.OrderDto;
import com.golden.shoe.shop.mapper.OrderMapper;
import com.golden.shoe.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/{orderNumber}")
    public List<OrderDto> getOrderByOrderNumber(@PathVariable String orderNumber) {
        return orderMapper.orderToOrderDtos(orderService.getByOrderNumber(orderNumber));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderDto> saveOrder() {
        return orderMapper.orderToOrderDtos(orderService.save());
    }

    @DeleteMapping("/{orderNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable String orderNumber) {
        orderService.deleteByOrderNumber(orderNumber);
    }
}
