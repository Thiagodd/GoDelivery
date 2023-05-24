package com.godelivery.godelivery.domain.exception;

import java.io.Serial;

public class EntityInUseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6610938185317576701L;

    public EntityInUseException(String message) {
        super(message);
    }
}
