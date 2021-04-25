package com.sahaj.assignment.service;

import com.sahaj.assignment.exception.FlightBookingException;
import com.sahaj.assignment.model.Cabin;
import com.sahaj.assignment.model.InvalidPassengerDetail;
import com.sahaj.assignment.model.PassengerDetail;
import com.sahaj.assignment.model.ValidPassengerDetail;
import com.sahaj.assignment.utility.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketUpgradationServiceTest {

    TicketUpgradationService ticketUpgradationService;
    FileHandler fileHandler;

    @Before
    public void init(){
        ticketUpgradationService = new TicketUpgradationService();
        fileHandler = new CSVFileHandler();
    }

    @Test
    public void readData() throws  FlightBookingException {
        ticketUpgradationService.upgradeTicket("inputFile.csv", "validOutput.csv", "invalidOutput.csv");
        File valid = new File("validOutput.csv");
        File invalid = new File("invalidOutput.csv");
        Assert.assertTrue(valid.exists());
        Assert.assertTrue(invalid.exists());

    }

    @Test
    public void testValidatePassengerDetail() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PassengerDetail> passengerDetailList = new ArrayList<>();
        PassengerDetail p1 = new PassengerDetail("Jyotirmay","Maity","ABC567",'D',sdf.parse("2019-07-25"),3,sdf.parse("2019-05-23"),"test@test.com","9876543423", Cabin.Business);
        PassengerDetail p2 = new PassengerDetail("Jyotirmay","Maity","A567",'D',sdf.parse("2019-07-25"),3,sdf.parse("2019-05-23"),"test@test.com","9876543423", Cabin.Business);
        passengerDetailList.add(p1);
        passengerDetailList.add(p2);
        List<ValidPassengerDetail> validPassengerDetails = new ArrayList<>();
        List<InvalidPassengerDetail> invalidPassengerDetails = new ArrayList<>();
        ticketUpgradationService.validatePassengerDetails(passengerDetailList,validPassengerDetails,invalidPassengerDetails);

        Assert.assertEquals(p1.getFirstName(), validPassengerDetails.get(0).getFirstName());
        Assert.assertEquals(p1.getLastName(), validPassengerDetails.get(0).getLastName());
        Assert.assertEquals(p1.getPnr(), validPassengerDetails.get(0).getPnr());
        Assert.assertEquals(p1.getFareClass(), validPassengerDetails.get(0).getFareClass());
        Assert.assertEquals(p1.getTravelDate(), validPassengerDetails.get(0).getTravelDate());
        Assert.assertEquals(p1.getPax(), validPassengerDetails.get(0).getPax());
        Assert.assertEquals(p1.getBookingDate(), validPassengerDetails.get(0).getBookingDate());
        Assert.assertEquals(p1.getEmail(), validPassengerDetails.get(0).getEmail());
        Assert.assertEquals(p1.getMobileNumber(), validPassengerDetails.get(0).getMobileNumber());
        Assert.assertEquals(p1.getCabin(), validPassengerDetails.get(0).getCabin());

        Assert.assertEquals(p2.getFirstName(), invalidPassengerDetails.get(0).getFirstName());
        Assert.assertEquals(p2.getLastName(), invalidPassengerDetails.get(0).getLastName());
        Assert.assertEquals(p2.getPnr(), invalidPassengerDetails.get(0).getPnr());
        Assert.assertEquals(p2.getFareClass(), invalidPassengerDetails.get(0).getFareClass());
        Assert.assertEquals(p2.getTravelDate(), invalidPassengerDetails.get(0).getTravelDate());
        Assert.assertEquals(p2.getPax(), invalidPassengerDetails.get(0).getPax());
        Assert.assertEquals(p2.getBookingDate(), invalidPassengerDetails.get(0).getBookingDate());
        Assert.assertEquals(p2.getEmail(), invalidPassengerDetails.get(0).getEmail());
        Assert.assertEquals(p2.getMobileNumber(), invalidPassengerDetails.get(0).getMobileNumber());
        Assert.assertEquals(p2.getCabin(), invalidPassengerDetails.get(0).getCabin());
        Assert.assertEquals(Constants.INVALID_PNR, invalidPassengerDetails.get(0).getInvalidReason());
    }

    @Test
    public void testCalculateDiscountCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<ValidPassengerDetail> validPassengerDetailList = new ArrayList<>();
        ValidPassengerDetail p1 = new ValidPassengerDetail("Jyotirmay","Maity","ABC567",'D',sdf.parse("2019-07-25"),3,sdf.parse("2019-05-23"),"test@test.com","9876543423", Cabin.Business);
        ValidPassengerDetail p2 = new ValidPassengerDetail("Jyotirmay","Maity","ABC567",'J',sdf.parse("2019-07-25"),3,sdf.parse("2019-05-23"),"test@test.com","9876543423", Cabin.Business);
        ValidPassengerDetail p3 = new ValidPassengerDetail("Jyotirmay","Maity","ABC567",'X',sdf.parse("2019-07-25"),3,sdf.parse("2019-05-23"),"test@test.com","9876543423", Cabin.Business);
        validPassengerDetailList.add(p1);
        validPassengerDetailList.add(p2);
        validPassengerDetailList.add(p3);
        ticketUpgradationService.calculateDiscountCode(validPassengerDetailList);
        Assert.assertEquals(Constants.DISCOUNT_OFFER_20, validPassengerDetailList.get(0).getDiscountCode());
        Assert.assertEquals(Constants.DISCOUNT_OFFER_30, validPassengerDetailList.get(1).getDiscountCode());
        Assert.assertNull(validPassengerDetailList.get(2).getDiscountCode());
    }
}
