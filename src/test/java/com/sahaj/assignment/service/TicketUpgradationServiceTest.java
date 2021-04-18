package com.sahaj.assignment.service;

import org.junit.Before;
import org.junit.Test;

public class TicketUpgradationServiceTest {

    TicketUpgradationService ticketUpgradationService;

    @Before
    public void init(){
        ticketUpgradationService = new TicketUpgradationService();
    }

    @Test
    public void readData(){
        ticketUpgradationService.upgradeTicket("test.csv", "output.csv");
    }
}
