package com.academiacx.handler.exceptions;

public class RecursoNaoEncontradoExeception extends  RuntimeException{

    public RecursoNaoEncontradoExeception(String mensagem){
        super(mensagem);
    }

    public RecursoNaoEncontradoExeception(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
