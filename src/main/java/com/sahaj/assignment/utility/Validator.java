package com.sahaj.assignment.utility;

import java.util.Date;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateEmailId(String emailId) {
        Pattern pattern = Pattern.compile(Constants.EMAIL_REGEX);
        if (emailId == null ) return false;
        return pattern.matcher(emailId).matches();
    }

    public static boolean validateIndianMobile(String mobileNumber){
        Pattern pattern = Pattern.compile(Constants.MOBILE_REGEX);
        if (mobileNumber == null) return false;
        return pattern.matcher(mobileNumber).matches();
    }

    public static boolean validatePnr(String pnr){
        Pattern pattern = Pattern.compile(Constants.PNR_REGEX);
        if (pnr == null) return false;
        return pattern.matcher(pnr).matches();
    }

    public static boolean validateBookingDate(Date bookingDate, Date travelDate){
        if (bookingDate == null || travelDate == null) return false;
        return travelDate.after(bookingDate);
    }
}
