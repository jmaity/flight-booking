package com.sahaj.assignment.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class PassengerDetail {

    @CsvBindByPosition(position = 0)
    private String firstName;
    @CsvBindByPosition(position = 1)
    private String lastName;
    @CsvBindByPosition(position = 2)
    private String pnr;
    @CsvBindByPosition(position = 3)
    private char fareClass;
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByPosition(position = 4)
    private Date travelDate;
    @CsvBindByPosition(position = 5)
    private int pax;
    @CsvBindByPosition(position = 6)
    @CsvDate(value = "yyyy-MM-dd")
    private Date bookingDate;
    @CsvBindByPosition(position = 7)
    private String email;
    @CsvBindByPosition(position = 8)
    private String mobileNumber;
    @CsvBindByPosition(position = 9)
    private Cabin cabin;

    public PassengerDetail(){}

    public PassengerDetail(String firstName, String lastName, String pnr, char fareClass, Date travelDate, int pax, Date bookingDate, String email, String mobileNumber, Cabin cabin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pnr = pnr;
        this.fareClass = fareClass;
        this.travelDate = travelDate;
        this.pax = pax;
        this.bookingDate = bookingDate;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.cabin = cabin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public char getFareClass() {
        return fareClass;
    }

    public void setFareClass(char fareClass) {
        this.fareClass = fareClass;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Cabin getCabin() {
        return cabin;
    }


    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }
}
