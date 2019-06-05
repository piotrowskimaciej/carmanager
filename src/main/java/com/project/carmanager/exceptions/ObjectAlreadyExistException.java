package com.project.carmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ObjectAlreadyExistException extends RuntimeException{

    public ObjectAlreadyExistException(Class object) {
        super("Object of type " + object.getSimpleName() + " actually is in database!");
    }

    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}

