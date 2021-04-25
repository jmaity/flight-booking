package com.sahaj.assignment.service;

import com.sahaj.assignment.model.Cabin;
import com.sahaj.assignment.model.PassengerDetail;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerTest {

    private FileHandler fileHandler;
    private SimpleDateFormat sdf;
    PassengerDetail passengerDetail;
    private String HEADER = "First_name,Last_name,PNR,Fare_class,Travel_date,Pax,Ticketing_date,Email,Mobile_phone,Booked_cabin";

    @Before
    public void init() throws ParseException {
        fileHandler = new CSVFileHandler();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        passengerDetail = new PassengerDetail("Monin","Sankar","PQR234",'C',sdf.parse("2019-08-30"),
                2, sdf.parse("2019-05-22"), "monin@zzz.com","9876543211", Cabin.Economy);
    }

    @After
    public void exit(){
        File f = new File("fileWriteTest.csv");
        f.delete();
    }

    @Test
    public void testReadFile() throws FileNotFoundException, ParseException {
        // Monin,Sankar,PQR234,C,2019-08-30,2,2019-05-22,monin@zzz.com,9876543211,Economy
        List<PassengerDetail> passengerDetailList = fileHandler.readFileDate("fileReadWrite.csv");
        Assert.assertEquals("Monin", passengerDetailList.get(0).getFirstName());
        Assert.assertEquals("Sankar", passengerDetailList.get(0).getLastName());
        Assert.assertEquals("PQR234", passengerDetailList.get(0).getPnr());
        Assert.assertEquals('C', passengerDetailList.get(0).getFareClass());
        Assert.assertEquals(sdf.parse("2019-08-30"), passengerDetailList.get(0).getTravelDate());
        Assert.assertEquals(2, passengerDetailList.get(0).getPax());
        Assert.assertEquals(sdf.parse("2019-05-22"), passengerDetailList.get(0).getBookingDate());
        Assert.assertEquals("monin@zzz.com", passengerDetailList.get(0).getEmail());
        Assert.assertEquals("9876543211", passengerDetailList.get(0).getMobileNumber());
        Assert.assertEquals(Cabin.Economy, passengerDetailList.get(0).getCabin());

    }

    @Test
    public void testWriteFile() throws IOException, ParseException {
        List<PassengerDetail> passengerDetailList = new ArrayList<>();
        passengerDetailList.add(passengerDetail);
        fileHandler.writeFileData(passengerDetailList, "fileWriteTest.csv", PassengerDetail.class, HEADER);
        passengerDetailList.clear();
        passengerDetailList = fileHandler.readFileDate("fileWriteTest.csv");
        Assert.assertEquals("Monin", passengerDetailList.get(0).getFirstName());
        Assert.assertEquals("Sankar", passengerDetailList.get(0).getLastName());
        Assert.assertEquals("PQR234", passengerDetailList.get(0).getPnr());
        Assert.assertEquals('C', passengerDetailList.get(0).getFareClass());
        Assert.assertEquals(sdf.parse("2019-08-30"), passengerDetailList.get(0).getTravelDate());
        Assert.assertEquals(2, passengerDetailList.get(0).getPax());
        Assert.assertEquals(sdf.parse("2019-05-22"), passengerDetailList.get(0).getBookingDate());
        Assert.assertEquals("monin@zzz.com", passengerDetailList.get(0).getEmail());
        Assert.assertEquals("9876543211", passengerDetailList.get(0).getMobileNumber());
        Assert.assertEquals(Cabin.Economy, passengerDetailList.get(0).getCabin());
    }
}
