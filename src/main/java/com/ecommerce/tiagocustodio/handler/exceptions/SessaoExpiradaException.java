package com.ecommerce.tiagocustodio.handler.exceptions;

public class SessaoExpiradaException extends RuntimeException {
    public SessaoExpiradaException(String message) {
        super(message);
    }

    public SessaoExpiradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
