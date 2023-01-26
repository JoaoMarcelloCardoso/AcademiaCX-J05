package com.ecommerce.igorfilgueira.service;

import com.ecommerce.igorfilgueira.handler.exceptions.ParametroInvalidoException;
import com.ecommerce.igorfilgueira.handler.exceptions.RecursoNaoEncontradoException;
import com.ecommerce.igorfilgueira.model.ProdutoModel;
import com.ecommerce.igorfilgueira.model.dto.ProdutoDto;
import com.ecommerce.igorfilgueira.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;   }

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

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    /*public ProdutoDto insert(ProdutoDto produtoDto) {
        produtoDto.setId(null);

        ProdutoDto result = new ProdutoDto(produtoRepository.save(new ProdutoModel(produtoDto)));

        return result;
    }*/

    public ProdutoModel update(ProdutoModel produtoModel) {
        findById(produtoModel);

        return produtoRepository.save(produtoModel);
    }

    public boolean delete(Long id) {
        findById(id);

        produtoRepository.deleteById(id);

        return true;
    }

}