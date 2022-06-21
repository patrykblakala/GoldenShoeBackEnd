package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dao.Status;
import com.golden.shoe.shop.domain.dao.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Page<Ticket> page(Pageable pageable);

    Ticket changeStatus(Long id, Status status);

    Ticket appointEmployee(Long ticketId, Long employeeId);
}
