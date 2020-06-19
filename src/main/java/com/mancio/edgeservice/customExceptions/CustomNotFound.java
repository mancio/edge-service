package com.mancio.edgeservice.customExceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFound extends RuntimeException {
    public CustomNotFound(Long id){
        super("Employee id: " + id + " - not found");
    }
}
