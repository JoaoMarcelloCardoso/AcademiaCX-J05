package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ProdutoModel;
import com.academiacx.model.dto.ProdutoDto;
import com.academiacx.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProdutoDto> findAll() {

        List<ProdutoModel> produtoModels = produtoRepository.findAll();

        return modelMapper.map(produtoModels, new TypeToken<List<ProdutoDto>>() {
        }.getType());
    }

    public ProdutoDto findById(ProdutoModel produtoModel) {

        if (produtoModel == null) {
            throw new ParametroInvalidoException("O Produto Model deve ser informado!");
        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("O Produto Model deve conter um id!");
        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto insert(ProdutoDto produtoDto) {

        produtoDto.setId(null);

        try {
            return new ProdutoDto(produtoRepository.save(new ProdutoModel(produtoDto)));
        } catch (Exception e) {
            throw new ConstraintViolationException("Algum dado inserido viola uma restrição do banco de dados (Dado duplicado)");
        }

    }

    public ProdutoDto update(ProdutoDto produtoDto) {

        findById(new ProdutoModel(produtoDto));

        try {
            return new ProdutoDto(produtoRepository.save(new ProdutoModel(produtoDto)));
        } catch (Exception e) {
            throw new ConstraintViolationException("Algum dado inserido viola uma restrição do banco de dados (Dado duplicado)");
        }

    }

    public boolean delete(Long id) {

        findById(id);

        try {
            produtoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
