package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.CartModel;
import com.cx.academy.exerciciontt.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartModel> findAll() {

        try {
            List<CartModel> cartList = cartRepository.findAll();
            if(cartList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint cart");
            }
            return cartList;
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar lista de carrinhos");
        }
    }

    public CartModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            return cartRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Carrinho não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar carrinho pelo id");
        }
    }

    public CartModel findById(CartModel cartModel) {
        if (cartModel == null) {
            throw new ParametroInvalidoException("A Cart Model deve ser informada");
        }

        if (cartModel.getId() == null) {
            throw new ParametroInvalidoException("A Cart Model deve conter um id");
        }

        try {
            return cartRepository.findById(cartModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Carrinho não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar carrinho pelo id");
        }
    }




    public CartModel insert(CartModel cartModel) {
        cartModel.setId(null);

        return cartRepository.save(cartModel);
    }


    public CartModel update(CartModel cartModel) {
        if(!cartRepository.existsById(cartModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe carrinho com o id informado");
        }

        try {
            return cartRepository.save(cartModel);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar carrinho");
        }
    }

    public boolean delete(Long id) {
        if(id == null || !cartRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe carrinho com o id informado");
        }
        try {
            cartRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar carrinho");
        }
    }
}
