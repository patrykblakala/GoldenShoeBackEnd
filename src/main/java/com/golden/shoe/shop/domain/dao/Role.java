package com.golden.shoe.shop.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = @Index(name = "idx_name", columnList = "name", unique = true))
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


}
