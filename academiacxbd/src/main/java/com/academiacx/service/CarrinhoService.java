package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.CarrinhoModel;
import com.academiacx.models.dto.CarrinhoDto;
import com.academiacx.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ModelMapper modelMapper;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ModelMapper modelMapper) {
        this.carrinhoRepository = carrinhoRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarrinhoDto> findAll() {
        List<CarrinhoModel> carrinhoModelList = carrinhoRepository.findAll();
        return modelMapper.map(carrinhoModelList, new TypeToken<List<CarrinhoDto>>() {
        }.getType());

    }

    public CarrinhoDto findById(Long id) {

        Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            CarrinhoModel carrinhoMapper = carrinhoRepository.findById(id).get();
            return modelMapper.map(carrinhoMapper, CarrinhoDto.class);

        }
        return null;
    }

    public CarrinhoDto save(CarrinhoDto carrinhoDto) {
        CarrinhoModel carrinhoModel = new CarrinhoModel();
        carrinhoModel.setTotal((carrinhoDto.getTotal()));
        carrinhoRepository.save(carrinhoModel);

        return modelMapper.map(carrinhoModel, CarrinhoDto.class);
    }

    public CarrinhoDto update(CarrinhoDto carrinhoDto) {
        Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(carrinhoDto.getId());
        if (carrinho.isPresent()) {
            CarrinhoModel carrinhoModel = carrinho.get();
            carrinhoModel.setTotal((carrinhoDto.getTotal()));
            carrinhoModel.setTotal((carrinhoDto.getTotal()));

            carrinhoRepository.save(carrinhoModel);
            return modelMapper.map(carrinhoModel, CarrinhoDto.class);
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public CarrinhoDto delete(CarrinhoDto carrinhoDto) {
        try {
            Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(carrinhoDto.getId());
            if (carrinho.isPresent()) {
                CarrinhoModel carrinhoModel = carrinho.get();
                carrinhoRepository.delete(carrinhoModel);
                return modelMapper.map(carrinhoModel, CarrinhoDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
