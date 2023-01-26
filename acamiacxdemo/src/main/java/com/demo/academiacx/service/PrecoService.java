package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.dto.PrecoDto;
import com.demo.academiacx.repository.PrecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {
    private PrecoRepository precoRepository;
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
            throw new ParametroInvalidoException("A Preço Model deve informada");

        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("A Preço Model deve conter um id");

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

        findById(precoModel);


        return precoRepository.save(precoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            PrecoDto precoDto = findById(id);
            try {
                precoRepository.deleteById(precoDto.getId());
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }

            return true;
        }
        return false;
    }

}
