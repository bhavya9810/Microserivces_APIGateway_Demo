package com.learning.booking.ticket_booking.controller;

import com.learning.booking.ticket_booking.entity.Ticket;
import com.learning.booking.ticket_booking.repository.TicketReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TicketController {

    @Autowired
    TicketReposiotry ticketReposiotry;

    @PostMapping
    public Ticket bookTicket(@RequestBody Ticket ticket){
        ticketReposiotry.save(ticket);

        return ticket;
    }
}
