package com.example.railwaystations_proj.exc_handling;

public class NoSuchInfoException extends RuntimeException{
    public NoSuchInfoException(String message){
        super(message);
    }
}
