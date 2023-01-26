package com.demo.academiacx.handler.exceptions;

public class RecursoIncorretoException extends RuntimeException {
    public RecursoIncorretoException(String mensagem){
        super(mensagem);
    }
    public RecursoIncorretoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
