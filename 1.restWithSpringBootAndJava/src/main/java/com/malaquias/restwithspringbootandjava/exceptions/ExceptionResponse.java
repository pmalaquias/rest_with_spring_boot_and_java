package com.malaquias.restwithspringbootandjava.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private Date timestamp;
    private String details;

    public ExceptionResponse(String message, Date timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
