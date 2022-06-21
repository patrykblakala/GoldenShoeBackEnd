package com.golden.shoe.shop.mapper;

import com.golden.shoe.shop.domain.dao.DiscountCode;
import com.golden.shoe.shop.domain.dto.DiscountCodeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountCodeMapper {

    DiscountCodeDto daoToDto(DiscountCode dao);

    DiscountCode dtoToDao(DiscountCodeDto dto);
}
