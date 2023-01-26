package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.dto.UserDto;
import com.spring.academiacx.repository.UserRepository;
import com.spring.academiacx.utils.ValidacaoUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> findAll() {
        List<UserModel> userModels = userRepository.findAll();


        return modelMapper.map(userModels, new TypeToken<List<UserDto>>() {
        }.getType());
    }

    public UserDto findById(UserModel userModel) {

        if (userModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (userModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            userModel = userRepository.findById(userModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }


        return modelMapper.map(userModel, UserDto.class);
    }


    public UserDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(userModel, UserDto.class);
    }

    public UserDto insert(UserDto userDto) {
        userDto.setId(null);

        validateSave(userDto);

        UserModel userModel = userRepository.save(modelMapper.map(userDto, UserModel.class));

        return modelMapper.map(userModel, UserDto.class);
    }

    public UserModel update(UserModel userModel) {


        return userRepository.save(userModel);
    }

    public boolean delete(Long id) {

        findById(id);

        userRepository.deleteById(id);

        return true;
    }



    public UserDto buscarPorId(Long id) {

        Optional<UserModel> userModel = userRepository.buscaPorId(id);

        if (userModel.isPresent())
        {
            return new UserDto(userModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }

    }
    private void validateSave(UserDto userDto) {
        ValidacaoUtils.validarTamanhoMinimo(userDto.getNome(), 3,"Nome deve conter 3 caracteres");

        ValidacaoUtils.validarTamanhoMinimo(userDto.getUsername(),5,"O username deve conter 5 caracteres no minimo" );

        ValidacaoUtils.PasswordValidator(userDto.getPassword(), "digit + lowercase char + uppercase char + punctuation + symbol");

        if (userDto.getNome() == null) {
            throw new ParametroInvalidoException("O nome deve ser informado");
        }
        if (userDto.getUsername() == null) {
            throw new ParametroInvalidoException("O username deve ser informado");
        }
        if (userDto.getPassword() == null) {
            throw new ParametroInvalidoException("A senha deve ser informada");
        }

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new ParametroInvalidoException("O usuario informado ja existe");
        }

    }


}

