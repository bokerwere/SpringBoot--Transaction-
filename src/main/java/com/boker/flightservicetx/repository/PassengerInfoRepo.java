package com.boker.flightservicetx.repository;

import com.boker.flightservicetx.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {
}
