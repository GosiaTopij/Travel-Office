package com.services;

import com.company.AbroadTrip;
import com.company.Customer;
import com.company.TravelOffice;
import com.company.Trip;
import com.exceptions.NoSuchCustomerException;
import com.exceptions.NoSuchTripException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TravelOfficeServiceTest {
    
    TravelOfficeService travelOfficeService;
    public TravelOfficeServiceTest() {
        this.travelOfficeService = new TravelOfficeService(new TravelOffice());
    }

    @Test
    public void addCustomer() {
        int a = travelOfficeService.getCustomerCount();
        Customer c = new Customer ("Maks");
        travelOfficeService.addCustomer(c);
        assertEquals(a+1,travelOfficeService.getCustomerCount());
    }

    @Test
    public void addTrip() {
        int a = travelOfficeService.getTripCount();
        Trip trip = new AbroadTrip(LocalDate.of(2000,05,20),LocalDate.of(2001,05,20),"Paryż");
        travelOfficeService.addTrip("1",trip);
        assertEquals(a+1,travelOfficeService.getTripCount());
    }

    @Test
    public void findCustomerByName() throws NoSuchCustomerException {
        String name = "Gosia";
        Customer expected = new Customer(name);
        travelOfficeService.addCustomer(expected);
        Customer result = travelOfficeService.findCustomerByName(name);
        assertEquals(expected,result);
    }

    @Test(expected = NoSuchCustomerException.class)
    public void exceptionWhenFindCustomerWhichDoesNotExist() throws NoSuchCustomerException {
       travelOfficeService.findCustomerByName("Dominik Kwiat");
    }

    @Test(expected = NoSuchTripException.class)
    public void exceptionWhenRemoveTripWhichDoesNotExist() throws NoSuchTripException {
        travelOfficeService.removeTrip("Lalaland");
    }

    @Test(expected = NoSuchCustomerException.class)
    public void exceptionWhenRemoveCustomerWhichDoesNotExist() throws NoSuchCustomerException {
        Customer c = new Customer("Dominik Kwiat");
        travelOfficeService.removeCustomer(c);
    }

    @Test(expected = NoSuchTripException.class)
    public void exceptionWhenFindTripWhichDoesNotExist() throws NoSuchTripException {
        travelOfficeService.findTripByDestination("Lalaland");
    }

}