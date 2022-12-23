package com.revature.CustomerTracker.Util.Aspects;

import com.revature.CustomerTracker.Util.Exceptions.InvalidCustomerInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionAspect {

    @ExceptionHandler({InvalidCustomerInputException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String exceptionInvalidCustomerInput(InvalidCustomerInputException ex){
        System.out.println("hello");
        if(ex.getMessage() == null){
            return "Login input was incorrect. Please check username or password.";
        } else {
            return ex.getMessage();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String validationHandler(Exception e){
        String[] strArray = e.getMessage().split(";");

        return strArray[strArray.length - 1];

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(Exception e){
        return e.toString() + e.getMessage();
    }
}
