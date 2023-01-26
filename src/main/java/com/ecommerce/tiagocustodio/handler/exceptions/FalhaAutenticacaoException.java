package com.ecommerce.tiagocustodio.handler.exceptions;

public class FalhaAutenticacaoException extends RuntimeException {
    public FalhaAutenticacaoException(String message) {
        super(message);
    }

    public FalhaAutenticacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
