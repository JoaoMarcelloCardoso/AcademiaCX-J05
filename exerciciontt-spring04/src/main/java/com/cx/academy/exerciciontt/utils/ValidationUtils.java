package com.cx.academy.exerciciontt.utils;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.model.dto.request.ClientDtoRequest;
import com.cx.academy.exerciciontt.repository.ClientRepository;

import java.util.regex.Pattern;

public interface ValidationUtils {



    static boolean validateName(String name) {
        return name.matches("^[a-zA-Z\\s]{5,30}$") && name.length() >= 5 && name.length() <= 30;
    }

    static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.[A-Z])(?=.*[@#$%^&+=]).{6,}$");
        return pattern.matcher(password).matches();
    }

    static boolean validateCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }





}
