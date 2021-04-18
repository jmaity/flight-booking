package com.sahaj.assignment.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Date;

public class ValidPassengerDetail extends PassengerDetail {

    @CsvBindByPosition(position = 10)
    private String discountCode;

    public ValidPassengerDetail(String firstName, String lastName, String pnr, char fareClass, Date travelDate, int pax, Date bookingDate, String email, String mobileNumber, Cabin cabin) {
        super(firstName, lastName, pnr, fareClass, travelDate, pax, bookingDate, email, mobileNumber, cabin);
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
