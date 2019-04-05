package org.acelera.brasil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FiltroInvalidoException extends RuntimeException {

    public FiltroInvalidoException(String message) {
        super(message);
    }
}
