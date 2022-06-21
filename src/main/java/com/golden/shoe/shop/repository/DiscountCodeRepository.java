package com.golden.shoe.shop.repository;

import com.golden.shoe.shop.domain.dao.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
}
