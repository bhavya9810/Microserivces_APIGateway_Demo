package com.learning.payment.payment_service.controller;


import com.learning.payment.payment_service.entity.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/pay")
    public Ticket doPayment(@RequestBody Ticket ticket){

        ticket.setStatus("Booked");

        return ticket;
    }

}
