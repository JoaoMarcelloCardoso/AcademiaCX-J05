package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.ProdutoModel;
import com.academiacx.models.dto.ProdutoDto;
import com.academiacx.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProdutoDto> findAll(){
        List<ProdutoModel> produtoModelList = produtoRepository.findAll();
        return modelMapper.map(produtoModelList, new TypeToken<List<ProdutoDto>>(){}.getType());

    }

    public ProdutoDto findById(Long id) {

        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            ProdutoModel produtoMapper = produtoRepository.findById(id).get();
            return modelMapper.map(produtoMapper, ProdutoDto.class);

        }
        return null;
    }

    public ProdutoDto save(ProdutoDto produtoDto) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome((produtoDto.getNome()));
        produtoModel.setSku((produtoDto.getSku()));
        produtoRepository.save(produtoModel);

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto update(ProdutoDto produtoDto){
        Optional<ProdutoModel> produto = produtoRepository.findById(produtoDto.getId());
        if (produto.isPresent()){
            ProdutoModel produtoModel = produto.get();
            produtoModel.setNome((produtoDto.getNome()));
            produtoModel.setSku((produtoDto.getSku()));

            produtoRepository.save(produtoModel);
            return modelMapper.map(produtoModel, ProdutoDto.class);
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public ProdutoDto delete(ProdutoDto produtoDto){
        try {
            Optional<ProdutoModel> produto = produtoRepository.findById(produtoDto.getId());
            if (produto.isPresent()) {
                ProdutoModel produtoModel = produto.get();
                produtoRepository.delete(produtoModel);
                return modelMapper.map(produtoModel, ProdutoDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}