package com.example.hwswaggerint6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends RuntimeException {

    public FacultyNotFoundException() {
        super();
    }
}