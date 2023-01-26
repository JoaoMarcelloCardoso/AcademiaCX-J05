package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.model.dto.PrecoDto;
import com.spring.academiacx.repository.PrecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new ParametroInvalidoException("A Preco Model deve informada");

        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("A Preco Model deve conter um id");

        }

        try {
            precoModel = precoRepository.findById(precoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
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
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto insert(PrecoDto precoDto) {
        precoDto.setId(null);

        PrecoDto result = new PrecoDto(precoRepository.save(new PrecoModel(precoDto)));

        return result;
    }

    public PrecoModel update(PrecoModel precoModel) {

        return precoRepository.save(precoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        precoRepository.deleteById(id);

        return true;
    }



    public PrecoDto buscarPorId(Long id) {

        Optional<PrecoModel> precoModel = precoRepository.buscaPorId(id);

        if (precoModel.isPresent())
        {
            return new PrecoDto(precoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}




