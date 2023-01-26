package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.model.dto.ProdutoDto;
import com.demo.academiacx.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
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
            throw new ParametroInvalidoException("A Produto Model deve informada");

        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("A Produto Model deve conter um id");

        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ProdutoModel ProdutoModel = new ProdutoModel();
        try {
            ProdutoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(ProdutoModel, ProdutoDto.class);
    }

    public ProdutoDto insert(ProdutoDto produtoDto) {
        produtoDto.setId(null);

        ProdutoDto result = new ProdutoDto(produtoRepository.save(new ProdutoModel(produtoDto)));

        return result;
    }

    public ProdutoModel update(ProdutoModel ProdutoModel) {

        findById(ProdutoModel);


        return produtoRepository.save(ProdutoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ProdutoDto produtoDto = findById(id);
            try {
                produtoRepository.deleteById(produtoDto.getId());
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }

            return true;
        }
        return false;
    }
}
