package com.golden.shoe.shop.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(indexes = @Index(name = "idx_name", columnList = "name", unique = true))
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String filePath;


}
