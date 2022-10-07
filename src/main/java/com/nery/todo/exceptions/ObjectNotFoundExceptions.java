package com.nery.todo.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException {

    public ObjectNotFoundExceptions(Throwable cause){
        super(cause);
    }

    public ObjectNotFoundExceptions(String message, Throwable cause){
        super(message, cause);
    }
    
}
