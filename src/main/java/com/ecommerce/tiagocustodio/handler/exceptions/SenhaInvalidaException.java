package com.ecommerce.tiagocustodio.handler.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String message) {
        super(message);
    }
    public SenhaInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
