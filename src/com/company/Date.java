package com.company;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Date of(String str){
        String[] parts = str.split("-");
        String part0 = parts[0];
        String part1 = parts[1];
        String part2 = parts[2];
        Date date = new Date(Integer.parseInt(part0),Integer.parseInt(part1),Integer.parseInt(part2));
        return date;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    String getInfo () {
        return "Date: " + year + "-" + month + "-" + day ;
    }

}
