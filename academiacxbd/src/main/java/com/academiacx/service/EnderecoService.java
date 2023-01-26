package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.EnderecoModel;
import com.academiacx.models.dto.EnderecoDto;
import com.academiacx.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<EnderecoModel> enderecoModelList = enderecoRepository.findAll();
        return modelMapper.map(enderecoModelList, new TypeToken<List<EnderecoDto>>() {
        }.getType());

    }

    public EnderecoDto findById(Long id) {

        Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            EnderecoModel enderecoMapper = enderecoRepository.findById(id).get();
            return modelMapper.map(enderecoMapper, EnderecoDto.class);

        }
        return null;
    }

    public EnderecoDto save(EnderecoDto enderecoDto) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setLogradouro((enderecoDto.getLogradouro()));
        enderecoModel.setNumero((enderecoDto.getNumero()));
        enderecoModel.setCidade((enderecoDto.getCidade()));
        enderecoModel.setBairro((enderecoDto.getBairro()));
        enderecoModel.setUf((enderecoDto.getUf()));
        enderecoRepository.save(enderecoModel);

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto update(EnderecoDto enderecoDto) {
        Optional<EnderecoModel> endereco = enderecoRepository.findById(enderecoDto.getId());
        if (endereco.isPresent()) {
            EnderecoModel enderecoModel = endereco.get();
            enderecoModel.setLogradouro((enderecoDto.getLogradouro()));
            enderecoModel.setNumero((enderecoDto.getNumero()));
            enderecoModel.setCidade((enderecoDto.getCidade()));
            enderecoModel.setBairro((enderecoDto.getBairro()));
            enderecoModel.setUf((enderecoDto.getUf()));

            enderecoRepository.save(enderecoModel);
            return modelMapper.map(enderecoModel, EnderecoDto.class);
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public EnderecoDto delete(EnderecoDto enderecoDto) {
        try {
            Optional<EnderecoModel> endereco = enderecoRepository.findById(enderecoDto.getId());
            if (endereco.isPresent()) {
                EnderecoModel enderecoModel = endereco.get();
                enderecoRepository.delete(enderecoModel);
                return modelMapper.map(enderecoModel, EnderecoDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}