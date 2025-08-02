package com.learning.booking.ticket_booking.controller;

import com.learning.booking.ticket_booking.entity.Ticket;
import com.learning.booking.ticket_booking.repository.TicketReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TicketController {

    @Autowired
    TicketReposiotry ticketReposiotry;

    @Autowired
    RestTemplate restTemplate;

//    @Value("${payment.url}")
//    String paymentUrl;

    @PostMapping
    public Ticket bookTicket(@RequestBody Ticket ticket)  {

        Ticket payload=null;
        System.out.println(ticket.toString());
        final String baseUrl="http://localhost:8082/pay";

        URI url;

        try{
            url=new URI(baseUrl);

            HttpHeaders headers=new HttpHeaders();
            headers.set("sample","true");
            headers.set("sample1","subscribe");

            HttpEntity<Ticket> request=new HttpEntity<>(ticket,headers);

            ResponseEntity<Ticket> response=restTemplate.exchange(
               url,
               HttpMethod.POST,
               request,
                Ticket.class
            );

            payload= response.getBody();
            ticketReposiotry.save(payload);

        }
        catch(URISyntaxException e){
            e.printStackTrace();
        }


        return payload;
    }
}
