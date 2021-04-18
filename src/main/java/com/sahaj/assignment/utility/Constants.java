package com.sahaj.assignment.utility;

public class Constants {

    public static final String INVALID_EMAIL = "Email Invalid";
    public static final String INVALID_PHONE = "Phone Invalid";
    public static final String INVALID_TICKET_DATE = "Ticketing Date Invalid";
    public static final String INVALID_PNR = "PNR Invalid";

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    public static final String MOBILE_REGEX = "^[6789]\\d{9}$";
    public static final String PNR_REGEX = "^[A-Z0-9]{6}";

    public static final String DISCOUNT_OFFER_20 = "OFFER_20";
    public static final String DISCOUNT_OFFER_30 = "OFFER_30";
    public static final String DISCOUNT_OFFER_25 = "OFFER_25";

    public static final String PROCESSED_FILE_HEADER = "First_name,Last_name,PNR,Fare_class,Travel_date,Pax,Ticketing_date,Email,Mobile_phone,Booked_cabin,Discount_code";
    public static final String FAILED_FILE_HEADER =  "First_name,Last_name,PNR,Fare_class,Travel_date,Pax,Ticketing_date,Email,Mobile_phone,Booked_cabin,Error";

}
