package com.company;

import java.util.Map;
import java.util.Scanner;

public class MainHandler implements UserInterface {

    TravelOffice travelOffice;
    Scanner scanner = null;

    public MainHandler(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
        scanner = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {
        System.out.print("Podaj imie: ");
        String fname = scanner.next();
        System.out.print("Podaj nazwisko: ");
        String lname = scanner.next();
        System.out.print("Podaj ulice: ");
        String street = scanner.next();
        System.out.print("Podaj kod kreskowy: ");
        String zip = scanner.next();
        System.out.print("Podaj miasto: ");
        String city = scanner.next();

        Address address = new Address(street, zip, city);
        Customer customer = new Customer(fname + " " + lname);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);

        System.out.println("Dodano klienta.'\n");
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.print("Trip id? ");
        String id = scanner.next();

        System.out.print("Trip destination? ");
        String destination = scanner.next();

        System.out.print("Trip start date (dd-mm-yyyy)? ");
        String start = scanner.next();
        Date startDate = Date.of(start, "-");

        System.out.print("Trip end date (dd-mm-yyyy)? ");
        String end = scanner.next();
        Date endDate = Date.of(end, "-");

        System.out.print("Trip price? ");
        int price = scanner.nextInt();

        System.out.print("Trip type (local/abroad)? ");
        String type = scanner.next();

        Trip trip = null;
        if (type.startsWith("a")) {
            System.out.print("Trip insurance? ");
            int insurance = scanner.nextInt();

            trip = new AbroadTrip(startDate, endDate, destination);
            trip.setPrice(price);
            ((AbroadTrip) trip).setInsurance(insurance);
            travelOffice.addTrip(id, trip);
        } else {
            System.out.print("Trip own arrival discount? ");
            int discount = scanner.nextInt();

            trip = new DomesticTrip(startDate, endDate, destination);
            trip.setPrice(price);
            ((DomesticTrip) trip).setOwnArrivalDiscount(discount);
            travelOffice.addTrip(id, trip);
        }
        System.out.println("Dodano wycieczke.'\n");
        return trip;
    }

    @Override
    public void assign() {
        System.out.print("Imie klienta: ");
        String name = scanner.next();

        Customer customer = travelOffice.findCustomerByName(name);
        if (customer == null) {
            System.out.println("Brak klienta o imieniu '" + name + "'\n");
            return;
        }

        System.out.print("Trip id: ");
        String id = scanner.next();

        Trip trip = travelOffice.getTrips().get(id);
        if (trip == null) {
            System.out.println("Brak wycieczki o indeksie: '" + id + "'\n");
            return;
        }
        customer.assignTrip(trip);

    }

    @Override
    public boolean removeCustomer() {
        System.out.print("Podaj imie: ");
        String customerName = scanner.next();

        Customer c = travelOffice.findCustomerByName(customerName);
        if (c == null) {
            System.out.println("No such customer has been found\n");
            return false;
        }
        travelOffice.removeCustomer(c);

        System.out.println("Customer has been removed...\n");
        return true;
    }

    @Override
    public boolean removeTrip() {
        System.out.print("Enter trip id: ");
        String id = scanner.next();
        boolean success = travelOffice.removeTrip(id);
        if (!success) {
            System.out.println("No such trip has been found\n");
            return false;
        }
        System.out.println("Trip has been removed...\n");
        return true;
    }

    @Override
    public void showTrips() {
        for (Map.Entry<String, Trip> entry : travelOffice.getTrips().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    @Override
    public void showCustomers() {
        System.out.println(travelOffice);
    }
}
