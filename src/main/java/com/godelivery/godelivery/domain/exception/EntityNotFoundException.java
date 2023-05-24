package com.godelivery.godelivery.domain.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4900339080489007839L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
