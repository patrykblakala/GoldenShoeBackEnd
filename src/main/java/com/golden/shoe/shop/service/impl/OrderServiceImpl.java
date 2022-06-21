package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dao.Order;
import com.golden.shoe.shop.domain.dao.Product;
import com.golden.shoe.shop.domain.dao.Status;
import com.golden.shoe.shop.repository.OrderRepository;
import com.golden.shoe.shop.service.BasketService;
import com.golden.shoe.shop.service.OrderService;
import com.golden.shoe.shop.service.ProductService;
import com.golden.shoe.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final BasketService basketService;
    private final ProductService productService;

    @Override
    public List<Order> save() {
        var orderNumber = UUID.randomUUID().toString();
        var currentUser = userService.getCurrentUser();

        List<Product> productsInBasket = basketService.getProductsInBasket();

        var order = productsInBasket.stream()
                .map(product -> Order.builder()
                        .totalPrice(product.getQuantity() * product.getPrice())
                        .numberOfItems(product.getQuantity())
                        .status(Status.CREATED)
                        .user(currentUser)
                        .product(productService.getById(product.getId()))
                        .orderNumber(orderNumber)
                        .build())
                .collect(Collectors.toList());
        orderRepository.saveAll(order);
        basketService.clearBasket();
        return order;
    }

    @Override
    public List<Order> getByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }

    @Override
    public void deleteByOrderNumber(String orderNumber) {
        orderRepository.deleteByOrderNumber(orderNumber);
    }

    @Override
    public Double getTotalOrderPrice() {
        return basketService.getProductsInBasket().stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

    @Override
    public List<Order> getOrderByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }
}
