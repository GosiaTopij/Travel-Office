package com.company;

public class AbroadTrip extends Trip {
    private double insurance;

    public AbroadTrip(Date start, Date end, String destination) {
        super(start, end, destination);
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getPrice() {
        return getPrice() + insurance;
    }
}
