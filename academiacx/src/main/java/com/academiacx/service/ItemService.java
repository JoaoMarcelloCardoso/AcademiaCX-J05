package com.academiacx.service;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ItemModel;
import com.academiacx.model.dto.ItemDto;
import com.academiacx.repository.ItemRepository;
import com.academiacx.utils.ValidacaoUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

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

    public ItemDto findById(ItemModel itemModel) {

        if (itemModel == null) {
            throw new ParametroInvalidoException("O Item Model deve ser informado!");
        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("O Item Model deve conter um id!");
        }

        try {
            itemModel = itemRepository.findById(itemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(itemModel, ItemDto.class);
    }

    public ItemDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ItemModel itemModel = new ItemModel();
        try {
            itemModel = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(itemModel, ItemDto.class);
    }

    public ItemDto insert(ItemDto itemDto) {

        itemDto.setId(null);

        try {
            return new ItemDto(itemRepository.save(new ItemModel(itemDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public ItemDto update(ItemDto itemDto) {

        findById(new ItemModel(itemDto));

        try {
            return new ItemDto(itemRepository.save(new ItemModel(itemDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

    }

    public boolean delete(Long id) {

        findById(id);

        itemRepository.deleteById(id);

        return true;
    }


}
