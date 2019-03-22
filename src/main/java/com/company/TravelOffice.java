package com.company;

import com.exceptions.NoSuchCustomerException;
import com.exceptions.NoSuchTripException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice {

    private Map<String, Trip> trips = new HashMap<>();
    private Set<Customer> customers = new HashSet<>();

    @Override
    public String toString() {
        String report = "";
        for (Customer c : customers) {
            report += c + "\n";
        }
        return report;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public int getTripCount(){
        return trips.size();
    }

    public void getInfo() {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void addTrip(String id, Trip trip) {
        trips.put(id, trip);
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        if (id != null) {
            if (trips.remove(id) == null) {
                throw new NoSuchTripException("Brak wycieczki o podanym id");
            }
        }
        throw new NoSuchTripException("Niepoprawne id wycieczki");
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
            throw new NoSuchCustomerException("Brak klienta o podanym imieniu.");
    }

    public boolean removeCustomer(Customer c) throws NoSuchCustomerException {
        if (c != null) {
            return customers.remove(c);
        }
        throw new NoSuchCustomerException("Brak klienta.");
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

}
