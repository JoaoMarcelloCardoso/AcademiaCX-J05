package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.models.ItemModel;
import com.academiacx.models.dto.ItemDto;
import com.academiacx.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
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

    public List<ItemDto> findAll(){
        List<ItemModel> itemModelList = itemRepository.findAll();
        return modelMapper.map(itemModelList, new TypeToken<List<ItemDto>>(){}.getType());

    }

    public ItemDto findById(Long id) {

        Optional<ItemModel> item = itemRepository.findById(id);
        if (item.isPresent()) {
            ItemModel itemMapper = itemRepository.findById(id).get();
            return modelMapper.map(itemMapper, ItemDto.class);

        }
        return null;
    }

    public ItemDto save(ItemDto itemDto) {
        ItemModel itemModel = new ItemModel();
        itemModel.setQuantidade((itemDto.getQuantidade()));
        itemModel.setTotal(itemDto.getTotal());
        itemRepository.save(itemModel);

        return modelMapper.map(itemModel, ItemDto.class);
    }

    public ItemDto update(ItemDto itemDto){
        Optional<ItemModel> item = itemRepository.findById(itemDto.getId());
        if (item.isPresent()){
            ItemModel itemModel = item.get();
            itemModel.setQuantidade(itemDto.getQuantidade());
            itemModel.setTotal(itemDto.getTotal());

            itemRepository.save(itemModel);
            return modelMapper.map(itemModel, ItemDto.class);
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public ItemDto delete(ItemDto itemDto){
        try {
            Optional<ItemModel> item = itemRepository.findById(itemDto.getId());
            if (item.isPresent()) {
                ItemModel itemModel = item.get();
                itemRepository.delete(itemModel);
                return modelMapper.map(itemModel, ItemDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
