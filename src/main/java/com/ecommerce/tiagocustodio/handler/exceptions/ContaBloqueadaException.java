package com.ecommerce.tiagocustodio.handler.exceptions;

public class ContaBloqueadaException extends RuntimeException {
    public ContaBloqueadaException(String message) {
        super(message);
    }

    public ContaBloqueadaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
