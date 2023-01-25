package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.ClientModel;
import com.cx.academy.exerciciontt.model.ItemModel;
import com.cx.academy.exerciciontt.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        try {
            List<ItemModel> itemList = itemRepository.findAll();
            if(itemList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint item");
            }
            return itemList;
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar items");
        }
    }

    public ItemModel findById(ItemModel itemModel) {
        if (itemModel == null) {
            throw new ParametroInvalidoException("A Item Model deve ser informada");
        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("A Item Model deve conter um id");
        }

        try {
            return itemRepository.findById(itemModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Item não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar item pelo id");
        }
    }

    public ItemModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            return itemRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Item não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar item pelo id");
        }
    }


    public ItemModel insert(ItemModel itemModel) {
        itemModel.setId(null);

        return itemRepository.save(itemModel);
    }


    public ItemModel update(ItemModel itemModel) {
        if(!itemRepository.existsById(itemModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe item com o id informado");
        }

        try {
            return itemRepository.save(itemModel);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar item");
        }
    }

    public boolean delete(Long id) {
        if(id == null || !itemRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe item com o id informado");
        }
        try {
            itemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar item");
        }
    }
}
