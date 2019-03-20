package com.company;

public class Customer {
    private String name;
    private Address address;
    private Trip trip;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", trip=" + trip +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    String getInfo () {
        return name + ", " + address.getInfo() +", "+ trip.getInfo() ;
    }

//    void addCustomer(Customer[] customers, Customer customer) {
//
//        for (int i = 0; i< customers.length; i++) {
//            if (customers[i] == null) {
//                customers[i] = customer;
//                break;
//            }
//            if (customers[i] != null && customers[customers.length-1] != null)
//            {
//                Customer customersCopy[] = Arrays.copyOf(customers,customers.length+1);
//                customersCopy[customers.length] = customer;
//            }
//        }
//    }

}
