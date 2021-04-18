package com.sahaj.assignment.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Date;

public class InvalidPassengerDetail extends PassengerDetail {

    @CsvBindByPosition(position = 10)
    private String invalidReason;

    public InvalidPassengerDetail(){}

    public InvalidPassengerDetail(String firstName, String lastName, String pnr, char fareClass, Date travelDate, int pax, Date bookingDate, String email, String mobileNumber, Cabin cabin, String invalidReason) {
        super(firstName, lastName, pnr, fareClass, travelDate, pax, bookingDate, email, mobileNumber, cabin);
        this.invalidReason = invalidReason;
    }

    public String getInvalidReason() {
        return invalidReason;
    }

    public void setInvalidReason(String invalidReason) {
        this.invalidReason = invalidReason;
    }
}
