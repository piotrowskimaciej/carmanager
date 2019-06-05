package com.project.carmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Class object) {
        super("Object of type " + object.getSimpleName() + " was not found!");
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}