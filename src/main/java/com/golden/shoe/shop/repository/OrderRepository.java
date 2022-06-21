package com.golden.shoe.shop.repository;

import com.golden.shoe.shop.domain.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderNumber(String orderNumber);

    void deleteByOrderNumber(String orderNumber);
}
