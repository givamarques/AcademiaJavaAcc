package io.machine.machine.io.models.enums;

import lombok.Getter;

@Getter
public enum Status {
    RECEBIDO(1),
    EM_ANDAMENTO(2),
    REPARADO(3),
    DEVOLVIDO(4);

//    ----------------------------------------------

    private final int code;

    private Status(int code){
        this.code = code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status Code");
    }
}
