package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.EnderecoModel;
import com.spring.academiacx.model.dto.EnderecoDto;
import com.spring.academiacx.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new ParametroInvalidoException("A Endereco Model deve informada");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("A Endereco Model deve conter um id");

        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
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
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto insert(EnderecoDto enderecoDto) {
        enderecoDto.setId(null);

        EnderecoDto result = new EnderecoDto(enderecoRepository.save(new EnderecoModel(enderecoDto)));

        return result;
    }

    public EnderecoModel update(EnderecoModel enderecoModel) {

        return enderecoRepository.save(enderecoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }



    public EnderecoDto buscarPorId(Long id) {

        Optional<EnderecoModel> enderecoModel = enderecoRepository.buscaPorId(id);

        if (enderecoModel.isPresent())
        {
            return new EnderecoDto(enderecoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}




