package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.model.dto.ItemDto;
import com.demo.academiacx.model.dto.ProdutoDto;
import com.demo.academiacx.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    public List<ItemDto> findAll() {
        List<ItemModel> itemModels = itemRepository.findAll();

        return modelMapper.map(itemModels, new TypeToken<List<ItemDto>>() {
        }.getType());
    }

    public ItemDto findById(ItemModel ItemModel) {

        if (ItemModel == null) {
            throw new ParametroInvalidoException("A Item Model deve informada");

        }

        if (ItemModel.getId() == null) {
            throw new ParametroInvalidoException("A Item Model deve conter um id");

        }

        try {
            ItemModel = itemRepository.findById(ItemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(ItemModel, ItemDto.class);
    }

    public ItemDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ItemModel itemModel = new ItemModel();
        try {
            itemModel = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(itemModel, ItemDto.class);
    }

    public ItemDto insert(ItemDto itemDto) {
        itemDto.setId(null);

        ItemDto result = new ItemDto(itemRepository.save(new ItemModel(itemDto)));

        return result;
    }

    public ItemModel update(ItemModel ItemModel) {

        findById(ItemModel);


        return itemRepository.save(ItemModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ItemDto itemDto = findById(id);
            try {
                itemRepository.deleteById(itemDto.getId());
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }

            return true;
        }
        return false;
    }
}
