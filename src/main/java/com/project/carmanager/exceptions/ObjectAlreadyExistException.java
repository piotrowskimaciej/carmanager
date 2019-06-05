package com.project.carmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ObjectAlreadyExistsException extends RuntimeException{

    public ObjectAlreadyExistsException(Class object) {
        super("Object of type " + object.getSimpleName() + " actually is in database!");
    }

    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}

