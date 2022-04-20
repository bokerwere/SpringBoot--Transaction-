package com.boker.flightservicetx.service;

import com.boker.flightservicetx.dto.FlightBookingAcknowledgement;
import com.boker.flightservicetx.dto.FlightBookingRequest;
import com.boker.flightservicetx.entity.PassengerInfo;
import com.boker.flightservicetx.entity.PaymentInfo;
import com.boker.flightservicetx.repository.PassengerInfoRepo;
import com.boker.flightservicetx.repository.PaymentInfoRepo;
import com.boker.flightservicetx.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
@Service

public class FlightBookingService {
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;
    @Autowired
    private PaymentInfoRepo paymentInfoRepo;
    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookingFleetTicket(FlightBookingRequest request) {
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepo.save(passengerInfo);
        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepo.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
