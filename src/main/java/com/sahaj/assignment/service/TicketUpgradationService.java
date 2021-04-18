package com.sahaj.assignment.service;

import com.sahaj.assignment.model.InvalidPassengerDetail;
import com.sahaj.assignment.model.PassengerDetail;
import com.sahaj.assignment.model.ValidPassengerDetail;
import com.sahaj.assignment.utility.Constants;
import com.sahaj.assignment.utility.Validator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketUpgradationService {

    private FileHandler fileHandler = new CSVFileHandler();

    public void upgradeTicket(String inputFilePath, String outputFilePath){
        try {
            List<PassengerDetail> passengerDetails = fileHandler.readFileDate(inputFilePath);
            passengerDetails.forEach(passenger -> {
                System.out.println(passenger.getLastName());
            });
            List<InvalidPassengerDetail> invalidPassengerDetails = new ArrayList<>();
            List<ValidPassengerDetail> validPassengerDetails = new ArrayList<>();
            validatePassengerDetails(passengerDetails, validPassengerDetails, invalidPassengerDetails);
            calculateDiscountCode(validPassengerDetails);
            fileHandler.writeFileData(validPassengerDetails, outputFilePath, ValidPassengerDetail.class);
            fileHandler.writeFileData(invalidPassengerDetails, "output_invalid.csv", InvalidPassengerDetail.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void validatePassengerDetails(List<PassengerDetail> passengerDetails, List<ValidPassengerDetail> validPassengerDetails, List<InvalidPassengerDetail> invalidPassengerDetails) {
        for (PassengerDetail passengerDetail : passengerDetails){
            if (!Validator.validateEmailId(passengerDetail.getEmail())){
                InvalidPassengerDetail invalidPassengerDetail = getInvalidPassenger(passengerDetail, Constants.INVALID_EMAIL);
                invalidPassengerDetails.add(invalidPassengerDetail);
            } else if (!Validator.validateIndianMobile(passengerDetail.getMobileNumber())){
                InvalidPassengerDetail invalidPassengerDetail = getInvalidPassenger(passengerDetail, Constants.INVALID_PHONE);
                invalidPassengerDetails.add(invalidPassengerDetail);
            } else if (!Validator.validatePnr(passengerDetail.getPnr())){
                InvalidPassengerDetail invalidPassengerDetail = getInvalidPassenger(passengerDetail, Constants.INVALID_PNR);
                invalidPassengerDetails.add(invalidPassengerDetail);
            } else if (!Validator.validateBookingDate(passengerDetail.getBookingDate(), passengerDetail.getTravelDate())){
                InvalidPassengerDetail invalidPassengerDetail = getInvalidPassenger(passengerDetail, Constants.INVALID_TICKET_DATE);
                invalidPassengerDetails.add(invalidPassengerDetail);
            } else {
                ValidPassengerDetail validPassengerDetail = getValidPassengerDetail(passengerDetail);
                validPassengerDetails.add(validPassengerDetail);
            }
        }
    }

    InvalidPassengerDetail getInvalidPassenger(PassengerDetail p, String invalidReason){
        return new InvalidPassengerDetail(p.getFirstName(),p.getLastName(),p.getPnr(),
                p.getFareClass(),p.getTravelDate(),p.getPax(),p.getBookingDate(),
                p.getEmail(),p.getMobileNumber(),p.getCabin(),invalidReason);
    }

    ValidPassengerDetail getValidPassengerDetail(PassengerDetail p){
        return new ValidPassengerDetail(p.getFirstName(),p.getLastName(),p.getPnr(),
                p.getFareClass(),p.getTravelDate(),p.getPax(),p.getBookingDate(),
                p.getEmail(),p.getMobileNumber(),p.getCabin());
    }

    void calculateDiscountCode(List<ValidPassengerDetail> validPassengerDetails){
        for (ValidPassengerDetail validPassengerDetail : validPassengerDetails){
            if (validPassengerDetail.getFareClass() <= 'E'){
                validPassengerDetail.setDiscountCode(Constants.DISCOUNT_OFFER_20);
            } else if (validPassengerDetail.getFareClass() >= 'F' && validPassengerDetail.getFareClass() <= 'K'){
                validPassengerDetail.setDiscountCode(Constants.DISCOUNT_OFFER_30);
            } else if (validPassengerDetail.getFareClass() >= 'L' && validPassengerDetail.getFareClass() <= 'R'){
                validPassengerDetail.setDiscountCode(Constants.DISCOUNT_OFFER_25);
            }
        }
    }
}
