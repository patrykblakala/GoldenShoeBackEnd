package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.BasketDto;
import com.golden.shoe.shop.domain.dto.ProductDto;

import com.golden.shoe.shop.mapper.ProductMapper;
import com.golden.shoe.shop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class BasketController {

    private final BasketService basketService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getBasket() {
        return productMapper.productsListDto((basketService.getProductsInBasket()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveProductsToBasket(@RequestBody @Valid BasketDto basketDto) {
        basketService.addToBasket(basketDto.getProductId(), basketDto.getQuantity());
    }

    @DeleteMapping("/{id}/product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductFromBasket(@PathVariable Long id) {
        basketService.deleteProduct(id);
    }
}

