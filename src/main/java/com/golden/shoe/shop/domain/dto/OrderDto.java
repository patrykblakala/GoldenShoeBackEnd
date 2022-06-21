package com.golden.shoe.shop.domain.dto;

import com.golden.shoe.shop.domain.dao.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private LocalDate createdDate;
    private Status status;
    private Integer numberOfItems;
    private Double totalPrice;
    private String orderNumber;
    private List<ProductDto> products;


}
