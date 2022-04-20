package com.boker.flightservicetx.repository;

import com.boker.flightservicetx.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String> {
}
