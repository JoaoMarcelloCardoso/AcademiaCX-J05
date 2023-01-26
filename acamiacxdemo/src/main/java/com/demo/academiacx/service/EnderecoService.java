package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.dto.EnderecoDto;
import com.demo.academiacx.repository.EnderecoRepository;
import com.demo.academiacx.utils.ValidacaoUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
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
    public EnderecoModel findModelById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        EnderecoModel enderecoModel = new EnderecoModel();
        try {
            enderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
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

        validarEndereco(enderecoDto);

        EnderecoDto result = new EnderecoDto(enderecoRepository.save(new EnderecoModel(enderecoDto)));

        return result;
    }

    public EnderecoModel update(EnderecoModel EnderecoModel) {

        findById(EnderecoModel);

        validarEndereco(new EnderecoDto(EnderecoModel));

        return enderecoRepository.save(EnderecoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            EnderecoModel enderecoModel = findModelById(id);
            try {
                enderecoRepository.deleteById(enderecoModel.getId());
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
    private void validarEndereco(EnderecoDto enderecoDto) {
        ValidacaoUtils.validarCep(enderecoDto.getCep(), "CEP inválido!");
        ValidacaoUtils.validarVazio(enderecoDto.getCidade(), "A Cidade é obrigatória!");
        ValidacaoUtils.validarTamanho(enderecoDto.getUf(), 2, 2, "UF inválida!");
    }
}
