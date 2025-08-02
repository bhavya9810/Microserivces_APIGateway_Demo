package com.learning.booking.ticket_booking.repository;

import com.learning.booking.ticket_booking.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReposiotry extends CrudRepository<Ticket,Long> {

}
