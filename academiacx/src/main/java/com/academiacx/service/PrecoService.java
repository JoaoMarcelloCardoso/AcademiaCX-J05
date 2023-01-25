package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.PrecoModel;
import com.academiacx.model.dto.PrecoDto;
import com.academiacx.repository.PrecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {

    private final PrecoRepository precoRepository;

    private final ModelMapper modelMapper;

    public PrecoService(PrecoRepository precoRepository, ModelMapper modelMapper) {
        this.precoRepository = precoRepository;
        this.modelMapper = modelMapper;
    }

    public List<PrecoDto> findAll() {

        List<PrecoModel> precoModels = precoRepository.findAll();

        return modelMapper.map(precoModels, new TypeToken<List<PrecoDto>>() {
        }.getType());
    }

    public PrecoDto findById(PrecoModel precoModel) {

        if (precoModel == null) {
            throw new ParametroInvalidoException("O Preço Model deve ser informado!");
        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("O Preço Model deve conter um id!");
        }

        try {
            precoModel = precoRepository.findById(precoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        PrecoModel precoModel = new PrecoModel();
        try {
            precoModel = precoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto insert(PrecoDto precoDto) {

        precoDto.setId(null);

        try {
            return new PrecoDto(precoRepository.save(new PrecoModel(precoDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public PrecoDto update(PrecoDto precoDto) {

        findById(new PrecoModel(precoDto));

        try {
            return new PrecoDto(precoRepository.save(new PrecoModel(precoDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public boolean delete(Long id) {

        findById(id);

        try {
            precoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
