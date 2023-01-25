package com.cx.academy.exerciciontt.service;


import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.ItemModel;
import com.cx.academy.exerciciontt.model.ProductModel;
import com.cx.academy.exerciciontt.model.dto.response.ClientDtoResponse;
import com.cx.academy.exerciciontt.model.dto.response.ProductDtoResponse;
import com.cx.academy.exerciciontt.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDtoResponse> findAll() {

        try {
            List<ProductModel> productList = productRepository.findAll();
            if(productList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint product");
            }
            return modelMapper.map(productList, new TypeToken<List<ProductDtoResponse>>() {}.getType());
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar lista de produtos");
        }
    }

    public ProductDtoResponse findById(ProductModel productModel) {
        if (productModel == null) {
            throw new ParametroInvalidoException("Produto Model deve ser informada");
        }

        if (productModel.getId() == null) {
            throw new ParametroInvalidoException("A Produto Model deve conter um id");
        }

        try {
           ProductModel product = productRepository.findById(productModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Produto não encontrado com o id informado"));
            return modelMapper.map(product, ProductDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar item pelo id");
        }
    }

    public ProductDtoResponse findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            ProductModel product = productRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Item não encontrado com o id informado"));
            return modelMapper.map(product, ProductDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar produto pelo id");
        }
    }


    public ProductDtoResponse insert(ProductModel productModel) {
        productModel.setId(null);

         productRepository.save(productModel);
         return modelMapper.map(productModel, ProductDtoResponse.class);
    }


    public ProductDtoResponse update(ProductModel productModel) {
        if(!productRepository.existsById(productModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe produto com o id informado");
        }

        try {
           productRepository.save(productModel);
           return modelMapper.map(productModel, ProductDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar produto");
        }
    }

    public boolean delete(Long id) {
        if(id == null || !productRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe produto com o id informado");
        }
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar produto");
        }
    }
}
