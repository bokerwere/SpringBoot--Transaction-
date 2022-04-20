package com.boker.flightservicetx.controller;

import com.boker.flightservicetx.dto.FlightBookingAcknowledgement;
import com.boker.flightservicetx.dto.FlightBookingRequest;
import com.boker.flightservicetx.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    @Autowired
    private FlightBookingService flightBookingService;
    @PostMapping("/POST")
    public FlightBookingAcknowledgement saveFlight( @RequestBody FlightBookingRequest request){
      return  flightBookingService.bookingFleetTicket(request);



    }
}
