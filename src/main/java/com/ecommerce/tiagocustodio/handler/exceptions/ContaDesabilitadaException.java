package com.ecommerce.tiagocustodio.handler.exceptions;

public class ContaDesabilitadaException extends RuntimeException {
    public ContaDesabilitadaException(String message) {
        super(message);
    }

    public ContaDesabilitadaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

