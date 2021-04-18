package com.sahaj.assignment.utility;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatorTest {

    @Test
    public void testValidateEmail(){
        Assert.assertEquals(false, Validator.validateEmailId("radhikazzz.com"));
        Assert.assertEquals(true, Validator.validateEmailId("abc@def.com"));
    }

    @Test
    public void testValidateMobile(){
        Assert.assertEquals(true, Validator.validateIndianMobile("7685743215"));
        Assert.assertEquals(false,Validator.validateIndianMobile("5678745326"));
        Assert.assertEquals(false, Validator.validateIndianMobile("984673645"));
    }

    @Test
    public void testValidatePnr(){
        Assert.assertEquals(true, Validator.validatePnr("WTY234"));
        Assert.assertEquals(false, Validator.validatePnr("QW345"));
    }

    @Test
    public void testValidateBookingDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        Assert.assertEquals(true, Validator.validateBookingDate(dateFormat.parse("2021-02-21"), dateFormat.parse("2021-03-21")));
        Assert.assertEquals(false, Validator.validateBookingDate(dateFormat.parse("2021-03-21"), dateFormat.parse("2021-03-20")));
    }
}
