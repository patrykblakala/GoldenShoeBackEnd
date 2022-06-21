package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dao.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ProductService {

    Product save(Product product, MultipartFile file);

    Product getById(Long id);

    Product update(Product product, MultipartFile file, Long id);

    void deleteById(Long id);

    Page<Product> page(Pageable pageable);

}
