package com.ecommerce.tiagocustodio.utils;

import java.util.regex.Pattern;

public interface ValidationUtils {

    static boolean validateName(String name) {
        return name.matches("^[a-zA-Z\\s]{8,50}$") && name.length() >= 8 && name.length() <= 50;
    }

    static boolean validateCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
    static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.[A-Z])(?=.*[@#$%]).{6,}$");
        return pattern.matcher(password).matches();
    }

}