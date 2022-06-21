package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.ProductDto;
import com.golden.shoe.shop.mapper.ProductMapper;
import com.golden.shoe.shop.service.ProductService;
import com.golden.shoe.shop.validator.ExtensionValid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productMapper.productDaoToProductDto(productService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto saveProduct(@RequestPart ProductDto productDto, @RequestPart @Valid @ExtensionValid MultipartFile file) {
        return productMapper.productDaoToProductDto(productService.save(productMapper.productDtoToProduct(productDto), file));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto updateProduct(@RequestPart ProductDto productDto, @RequestPart @Valid @ExtensionValid MultipartFile file, @PathVariable Long id) {
        return productMapper.productDaoToProductDto(productService.update(productMapper.productDtoToProduct(productDto), file, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<ProductDto> pageProduct(@RequestParam int page, @RequestParam int size) {
        return productService.page(PageRequest.of(page, size))
                .map(productMapper::productDaoToProductDto);
    }

}

