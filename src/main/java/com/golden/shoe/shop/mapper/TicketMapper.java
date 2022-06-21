package com.golden.shoe.shop.mapper;

import com.golden.shoe.shop.domain.dao.Ticket;
import com.golden.shoe.shop.domain.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket dtoToDao(TicketDto ticketDto);

    TicketDto daoToDto(Ticket ticket);

}
