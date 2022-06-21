package com.golden.shoe.shop.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscountCodeDto {

    private Long id;

    private Double percentage;

    private Double value;

    private Integer useCount;

    private String code;

    private Long offerId;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;

}
