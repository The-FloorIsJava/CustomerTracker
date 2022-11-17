package com.revature.CustomerTracker.Util.Exceptions;

public class InvalidCustomerInputException extends RuntimeException{

    public InvalidCustomerInputException(String message) {
        super(message);
    }
}
