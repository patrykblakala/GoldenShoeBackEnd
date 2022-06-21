package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.config.FilePathPropertiesConfig;
import com.golden.shoe.shop.domain.dao.Product;
import com.golden.shoe.shop.repository.ProductRepository;
import com.golden.shoe.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final FilePathPropertiesConfig filePathPropertiesConfig;

    @Override
    @Transactional
    public Product save(Product product, MultipartFile file) {
        productRepository.save(product);
        Path path = Paths.get(filePathPropertiesConfig.getProductsPath(),
                product.getId().toString() + "." + FileNameUtils.getExtension(file.getOriginalFilename()));
        try {
            Files.copy(file.getInputStream(), path);
            product.setFilePath(path.toString());
        } catch (IOException e) {
            log.error("Couldn't save product image", e);
        }
        return product;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Product update(Product product, MultipartFile file, Long id) {

        var productDb = getById(id);
        Path path = Paths.get(filePathPropertiesConfig.getProductsPath(),
                id + "." + FileNameUtils.getExtension(file.getOriginalFilename()));
        try {

            Path oldPath = Paths.get(productDb.getFilePath());

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            if (!path.equals(oldPath) && Files.exists(oldPath)) {
                Files.delete(oldPath);
            }
            productDb.setFilePath(path.toString());
        } catch (IOException e) {
            log.error("Couldn't save product image", e);
        }
        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        productDb.setQuantity(product.getQuantity());
        return productRepository.save(productDb);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Product> page(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
