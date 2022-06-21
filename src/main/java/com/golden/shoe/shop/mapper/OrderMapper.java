package com.golden.shoe.shop.mapper;

import com.golden.shoe.shop.domain.dao.Order;
import com.golden.shoe.shop.domain.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    List<OrderDto> orderToOrderDtos(List<Order> orders);
}
