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

    boolean removeTrip(String id) {
        if (id != null) {
            trips.remove(id);
            return true;
        }
        return false;
    }

    Customer findCustomerByName(String name) {
        for (Customer c : customers) {
            if (name.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }

    boolean removeCustomer(Customer c) {
        if (c != null) {
            return customers.remove(c);
        }
        return false;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

}
