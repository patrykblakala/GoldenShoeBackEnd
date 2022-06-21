package com.golden.shoe.shop.mapper;

import com.golden.shoe.shop.domain.dao.Product;
import com.golden.shoe.shop.domain.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productDaoToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productsListDto(List<Product> productList);
}
