package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice {

    @Override
    public String toString() {
        String report = "";
        for (Customer c : customers) {
            report += c + "\n";
        }
        return report;
    }

    Map<String, Trip> trips = new HashMap<>();
    Set<Customer> customers = new HashSet<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public void getInfo() {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    void addTrip(String id, Trip trip) {
        trips.put(id, trip);
    }

    boolean removeTrip(String id) throws NoSuchTripException {
        if (id != null) {
            if (trips.remove(id) == null) {
                throw new NoSuchTripException("Brak wycieczki o podanym id");
            }
        }
        throw new NoSuchTripException("Niepoprawne id wycieczki");
    }

    Customer findCustomerByName(String name) throws NoSuchCustomerException {
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
            throw new NoSuchCustomerException("Brak klienta o podanym imieniu.");
    }

    boolean removeCustomer(Customer c) throws NoSuchCustomerException {
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
