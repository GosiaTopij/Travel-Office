package com.company;

public class NoSuchCustomerException extends Exception {
    public NoSuchCustomerException(String message) {
        super(message);
    }
}
