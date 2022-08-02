package com.nttdata.bancamicroservices.exception;

/**
 *
 */
public class UnknownEnumValueException extends RuntimeException{
    public UnknownEnumValueException(String message){
        super(message);
    }
}
