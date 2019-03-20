package com.company;

public class Test {
    public static void main(String[] args) {


        // utworz biuro podrozy
        TravelOffice to = new TravelOffice();

        // budujemy wycieczke
        Trip trip = new Trip(new Date(2017, 8, 1), new Date(2017, 8, 15), "Egipt",5000.0);

        // budujemy pierwszego klienta
        Customer customer = new Customer("Jan Kowalski");
        customer.setAddress(new Address("Marszalkowska 10", "00-876", "Warszawa"));
        customer.assignTrip(trip);
        to.addCustomer(customer); // dodajemy go do biura

        customer = new Customer("Jozef Nowak");
        customer.setAddress(new Address("Al. Jerozolimskie 120", "00-345", "Warszawa"));
        customer.assignTrip(trip);
        to.addCustomer(customer); // dodajemy go do biura

        customer = new Customer("Jaroslaw Lis");
        customer.setAddress(new Address("Swietokrzyska 14", "00-666", "Warszawa"));
        customer.assignTrip(trip);
        to.addCustomer(customer); // dodajemy go do biura

        System.out.println(to.getInfo());

        Trip trip1 = new DomesticTrip(new Date(2017, 8, 1), new Date(2017, 8, 15), "Paryż",5000.0,1000.0);

        Trip trip2 = new AbroadTrip(new Date(2016, 8, 1), new Date(2016, 8, 15), "Majorka",8000.0,2000.0);
        trip1.toString();

        System.out.println("Data: ");

        String str = "11-44-55";
   //     Date d1 = Date.of(str);
        Date.of(str).toString();
        Date d = new Date(11,22,55);
        d.toString();

    }
}
