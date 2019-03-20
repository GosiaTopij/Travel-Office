package com.company;

public class DomesticTrip extends Trip {
    private double ownArrivalDiscount;

    public DomesticTrip(Date start, Date end, String destination) {
        super(start, end, destination);
    }

    public double getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }

}
