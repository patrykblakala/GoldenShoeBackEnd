package com.golden.shoe.shop.repository;

import com.golden.shoe.shop.domain.dao.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProductRepository extends JpaRepositoryImplementation<Product, Long> {
}
