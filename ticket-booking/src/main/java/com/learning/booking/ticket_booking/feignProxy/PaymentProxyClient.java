package com.learning.booking.ticket_booking.feignProxy;

import com.learning.booking.ticket_booking.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service", url="localhost:8082")
public interface PaymentProxyClient {

    @PostMapping("/pay")
    public Ticket doPayment(@RequestBody Ticket ticket);
}
