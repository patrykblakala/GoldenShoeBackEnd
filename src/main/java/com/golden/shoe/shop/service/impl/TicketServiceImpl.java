package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dao.Status;
import com.golden.shoe.shop.domain.dao.Ticket;
import com.golden.shoe.shop.repository.EmployeeRepository;
import com.golden.shoe.shop.repository.TicketRepository;
import com.golden.shoe.shop.service.TicketService;
import com.golden.shoe.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final UserService userService;

    private final TicketRepository ticketRepository;

    private EmployeeRepository employeeRepository;


    @Override
    public Ticket createTicket(Ticket ticket) {
        ticket.setUser(userService.getCurrentUser());
        return ticketRepository.save(ticket);
    }

    @Override
    public Page<Ticket> page(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    @Override
    public Ticket changeStatus(Long id, Status status) {
        var ticketDb = ticketRepository.getById(id);
        ticketDb.setStatus(status);
        return ticketRepository.save(ticketDb);
    }

    @Override
    public Ticket appointEmployee(Long ticketId, Long employeeId) {
        var ticketDb = ticketRepository.getById(ticketId);
        var employee = employeeRepository.getById(employeeId);
        ticketDb.setEmployee(employee);
        return ticketRepository.save(ticketDb);
    }
}
