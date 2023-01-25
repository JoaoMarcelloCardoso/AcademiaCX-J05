package com.academiacx.service;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.EnderecoModel;
import com.academiacx.model.dto.EnderecoDto;
import com.academiacx.repository.EnderecoRepository;
import com.academiacx.utils.ValidacaoUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final ModelMapper modelMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, ModelMapper modelMapper) {
        this.enderecoRepository = enderecoRepository;
        this.modelMapper = modelMapper;
    }

    public List<EnderecoDto> findAll() {

        List<EnderecoModel> enderecoModels = enderecoRepository.findAll();

        return modelMapper.map(enderecoModels, new TypeToken<List<EnderecoDto>>() {
        }.getType());
    }

    public EnderecoDto findById(EnderecoModel enderecoModel) {

        if (enderecoModel == null) {
            throw new ParametroInvalidoException("O Endereço Model deve ser informado!");
        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("O Endereço Model deve conter um id!");
        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        EnderecoModel enderecoModel = new EnderecoModel();
        try {
            enderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto insert(EnderecoDto enderecoDto) {

        enderecoDto.setId(null);

        validarEndereco(enderecoDto);

        enderecoDto.setCep(enderecoDto.getCep().replace("-", ""));

        try {
            return new EnderecoDto(enderecoRepository.save(new EnderecoModel(enderecoDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public EnderecoDto update(EnderecoDto enderecoDto) {

        findById(new EnderecoModel(enderecoDto));

        validarEndereco(enderecoDto);

        enderecoDto.setCep(enderecoDto.getCep().replace("-", ""));

        try {
            return new EnderecoDto(enderecoRepository.save(new EnderecoModel(enderecoDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public boolean delete(Long id) {

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }


    private void validarEndereco(EnderecoDto enderecoDto) {
        ValidacaoUtils.validarCep(enderecoDto.getCep(), "CEP não foi inserido ou é inválido!");
        ValidacaoUtils.validarVazio(enderecoDto.getCidade(), "A cidade é obrigatória!");
        ValidacaoUtils.validarRangeTamanho(enderecoDto.getUf(), 2, 2, "UF inserida inválida!");
    }
}
