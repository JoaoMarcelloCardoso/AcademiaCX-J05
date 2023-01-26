package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ItemModel;
import com.spring.academiacx.model.dto.ItemDto;
import com.spring.academiacx.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new ParametroInvalidoException("A Item Model deve informada");

        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("A Item Model deve conter um id");

        }

        try {
            itemModel = itemRepository.findById(itemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
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
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(itemModel, ItemDto.class);
    }

    public ItemDto insert(ItemDto itemDto) {
        itemDto.setId(null);

        ItemDto result = new ItemDto(itemRepository.save(new ItemModel(itemDto)));

        return result;
    }

    public ItemModel update(ItemModel itemModel) {

        return itemRepository.save(itemModel);
    }

    public boolean delete(Long id) {

        findById(id);

        itemRepository.deleteById(id);

        return true;
    }



    public ItemDto buscarPorId(Long id) {

        Optional<ItemModel> itemModel = itemRepository.buscaPorId(id);

        if (itemModel.isPresent())
        {
            return new ItemDto(itemModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}




