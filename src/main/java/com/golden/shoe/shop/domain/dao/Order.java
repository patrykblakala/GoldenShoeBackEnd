package com.golden.shoe.shop.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String orderNumber;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private Status status;

    private Integer numberOfItems;

    private Double totalPrice;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;


}
