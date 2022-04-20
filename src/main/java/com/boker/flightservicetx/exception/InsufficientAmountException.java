package com.boker.flightservicetx.exception;

public class InsufficientAmountException extends RuntimeException{
    //add constructor
    public InsufficientAmountException(String msg){
        super(msg);
    }
}
