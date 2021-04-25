package com.sahaj.assignment.exception;

public class FlightBookingException extends Exception {

    public FlightBookingException(String message){
        super(message);
    }

    public FlightBookingException(String message, Exception e){
        super(message, e);
    }

    public FlightBookingException(Exception e){
        super(e);
    }
}
