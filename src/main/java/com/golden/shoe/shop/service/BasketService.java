package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dao.Product;

import java.util.List;

public interface BasketService {

    void addToBasket(Long productId, Integer quantity);

    void deleteProduct(Long productId);

    void clearBasket();

    List<Product> getProductsInBasket();
}
