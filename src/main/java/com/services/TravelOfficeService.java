package com.services;

import com.company.Customer;
import com.company.TravelOffice;
import com.company.Trip;
import com.exceptions.NoSuchCustomerException;
import com.exceptions.NoSuchTripException;

import java.util.Map;
import java.util.Set;

public class TravelOfficeService {

    private TravelOffice travelOffice = new TravelOffice();

    public TravelOfficeService(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }

    public TravelOfficeService() {
    }

    public int getTripCount(){
        return travelOffice.getTripCount();
    }

    public int getCustomerCount() {
        return travelOffice.getCustomerCount();
    }

    public void addCustomer(Customer customer) {
        travelOffice.addCustomer(customer);
    }

    public void getInfo() {
        travelOffice.getInfo();
    }

    public void addTrip(String id, Trip trip) {
        travelOffice.addTrip(id,trip);
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        return travelOffice.removeTrip(id);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(name);
    }

    public boolean removeCustomer(Customer c) throws NoSuchCustomerException {
        return travelOffice.removeCustomer(c);
    }
    public void findTripByDestination(String destination) throws NoSuchTripException {
        travelOffice.findTripByDestination(destination);
    }

    public Set<Customer> getCustomers() {
        return travelOffice.getCustomers();
    }

    public Map<String, Trip> getTrips() {
        return travelOffice.getTrips();
    }
}
