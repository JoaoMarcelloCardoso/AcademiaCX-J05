package com.academiacx.utils;

import com.academiacx.handler.exceptions.CpfInvalidoException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.TamanhoInvalidoException;


public interface ValidacaoUtils {


    static void validarVazio(String valor, String errorMessage) {
        if (valor == null || valor.isEmpty() || valor.isBlank()) {
            throw new ParametroNullException(errorMessage);
        }
    }

    static void validarRangeTamanho(String valor, int tamanhoMinimo, int tamanhoMaximo, String errorMessage) {

        validarVazio(valor, errorMessage);

        if (valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
            throw new TamanhoInvalidoException(errorMessage);
        }
    }


    static void validarCep(String cep, String errorMessage) {

        validarVazio(cep, errorMessage);

        if (!cep.matches("\\d{5}-?\\d{3}")) {
            throw new ParametroInvalidoException(errorMessage);
        }
    }


    static void validarCpf(String cpf, String errorMessage) {

        validarVazio(cpf, errorMessage);

        if (!cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new CpfInvalidoException(errorMessage);
        }

        cpf = cpf.replace(".", "")
                .replace("-", "");


        verificarCpf(cpf, errorMessage);
    }

    private static void verificarCpf(String cpf, String errorMessage) {
        int num, dig10, dig11, sm = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm += (num * peso);
            peso = peso - 1;
        }

        int r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        } else {
            dig10 = (char) (r + 48);
        }

        sm = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + 48);
        }

        if (!((dig10 == cpf.charAt(9)) || (dig11 == cpf.charAt(10)))) {
            throw new CpfInvalidoException(errorMessage);
        }
    }

}
