package com.golden.shoe.shop.repository;

import com.golden.shoe.shop.domain.dao.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket getById(Long id);
}
