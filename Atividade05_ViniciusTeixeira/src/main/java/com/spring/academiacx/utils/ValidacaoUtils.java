package com.spring.academiacx.utils;

import com.mysql.cj.util.StringUtils;
import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidacaoUtils {

    static void validarTamanhoMinimo(String valor, int tamanhoMinimo, String errormsgs) {
        if (tamanhoMinimo == 0) {
            return;
        }
        if (valor == null || valor.length() < tamanhoMinimo) {
            throw new ParametroInvalidoException(errormsgs);
        }
    }

    static void validarTamanhoMaximo(String valor, int tamanhoMaximo, String errormsgs) {
        if (valor != null && valor.length() > tamanhoMaximo) {
            throw new ParametroInvalidoException(errormsgs);
        }
    }

    static void PasswordValidator(String password, String msg) {

        // digit + lowercase char + uppercase char + punctuation + symbol

        String PASSWORD_REGEX =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if (!matcher.matches()) {
            throw new ParametroInvalidoException(msg);
        }

    }
}
