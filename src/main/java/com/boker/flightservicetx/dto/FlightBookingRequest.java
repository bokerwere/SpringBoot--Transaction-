package com.boker.flightservicetx.dto;

import com.boker.flightservicetx.entity.PassengerInfo;
import com.boker.flightservicetx.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//request and Response
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo  passengerInfo;
    private PaymentInfo paymentInfo;
}
