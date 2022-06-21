package com.golden.shoe.shop.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.golden.shoe.shop.domain.dao.TicketType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {

    private Long id;

    @NotBlank
    private String message;

    @NotNull
    private TicketType ticketType;
}