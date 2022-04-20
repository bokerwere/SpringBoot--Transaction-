package com.boker.flightservicetx.util;

import com.boker.flightservicetx.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

//for validating credit limit
public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();

   static  {
        paymentMap.put("acc1", 2000.00);
        paymentMap.put("acc2", 1000.00);
        paymentMap.put("acc3", 2000.00);
        paymentMap.put("acc3", 500.00);
        paymentMap.put("acc5", 12000.00);

    }
    public static boolean validateCreditLimit(String accNo, double paidAmout){
        if (paidAmout>paymentMap.get(accNo)){
            throw new InsufficientAmountException("insufficient fund--!!!");

        }else {
            return true;
        }
    }}
