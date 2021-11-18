package io.machine.machine.io.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Instant status;
    private String error;
    private String message;
    private String path;

    public StandardError(Instant now, int value, String error, String message, String requestURI) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
