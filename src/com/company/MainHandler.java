package com.company;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainHandler implements UserInterface {

    private static Logger logger = Logger.getLogger("com.company");
    private TravelOffice travelOffice;
    private Scanner scanner = null;

    public MainHandler(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
        scanner = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {
        System.out.print("Podaj imie: ");
        String name = scanner.next();
        System.out.print("Podaj ulice: ");
        String street = scanner.next();
        System.out.print("Podaj kod kreskowy: ");
        String zip = scanner.next();
        System.out.print("Podaj miasto: ");
        String city = scanner.next();

        Address address = new Address(street, zip, city);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);

        System.out.println("Dodano klienta.'\n");
        logger.info("Dodano nowego klienta");
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.print("Id wycieczki: ");
        String id = scanner.next();
        System.out.print("Podaj date startową: (yyyy-mm-dd)");
        String startDate = scanner.next();
        System.out.print("Podaj date końcową: (yyyy-mm-dd)");
        String endDate = scanner.next();
        System.out.print("Podaj cel podróży: ");
        String destination = scanner.next();
        System.out.print("Podaj cene: ");
        double price = scanner.nextDouble();
        System.out.print("Podaj typ podróży: (krajowy/zagraniczny)");
        String type = scanner.next();

        if (type.equals("krajowy")) {
            System.out.print("Podaj kwote rabatu: ");
            double discount = scanner.nextDouble();
            Trip domesticTrip = new DomesticTrip(LocalDate.parse(startDate), LocalDate.parse(endDate), destination);
            domesticTrip.setPrice(price);
            ((DomesticTrip) domesticTrip).setOwnArrivalDiscount(discount);
            domesticTrip.setPrice(price);
            travelOffice.addTrip(id, domesticTrip);
            logger.info("Dodano nową wycieczke.");
            return domesticTrip;
        } else if (type.equals("zagraniczny")) {
            System.out.print("Podaj kwote ubezpieczenia: ");
            double insurance = scanner.nextDouble();
            Trip abroadTrip = new AbroadTrip(LocalDate.parse(startDate), LocalDate.parse(endDate), destination);
            ((AbroadTrip) abroadTrip).setInsurance(insurance);
            abroadTrip.setPrice(price);
            travelOffice.addTrip(id, abroadTrip);
            logger.info("Dodano nową wycieczke.");
            return abroadTrip;
        } else {
            System.out.println("Niepoprawny typ podróży");
        }
        return null;
    }

    @Override
    public void assign() {
        System.out.println("Podaj imie klienta: ");
        String name = scanner.next();
        System.out.println("Podaj id wycieczki: ");
        String id = scanner.next();

        Customer customer = null;
        try {
            customer = travelOffice.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            e.printStackTrace();
            logger.warning("NoSuchCustomerException");
        }
        Trip trip = travelOffice.trips.get(id);

        if (trip == null) System.out.println("Brak wycieczki z id: " + id);
        else {
            customer.assignTrip(trip);
            System.out.println("Przypisano wycieczke do klienta");
            logger.info("Przypisano wycieczke do klienta.");
        }
    }

    @Override
    public boolean removeCustomer() {
        System.out.print("Podaj imie klienta: ");
        String name = scanner.next();
        travelOffice.getCustomers().removeIf(c -> c.toString().contains(name));
        return true;
    }

    @Override
    public boolean removeTrip() {
        System.out.print("Id wycieczki: ");
        String id = scanner.next();

        try {
            travelOffice.removeTrip(id);
        } catch (NoSuchTripException e) {
            e.printStackTrace();
            logger.warning("NoSuchTripException");
            return false;
        }
        logger.info("Usunięto wycieczkę.");
        return true;
    }

    @Override
    public void showTrips() {
        travelOffice.getTrips().entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    @Override
    public void showCustomers() {
        travelOffice.getCustomers().forEach(c -> System.out.println(c));
    }
}
