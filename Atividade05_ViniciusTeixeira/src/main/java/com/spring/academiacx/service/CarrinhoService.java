package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.model.dto.CarrinhoDto;
import com.spring.academiacx.repository.CarrinhoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

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
        List<CarrinhoModel> carrinhoModels = carrinhoRepository.findAll();


        return modelMapper.map(carrinhoModels, new TypeToken<List<CarrinhoDto>>() {
        }.getType());
    }

    public CarrinhoDto findById(CarrinhoModel carrinhoModel) {

        if (carrinhoModel == null) {
            throw new ParametroInvalidoException("A Endereco Model deve informada");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("A Endereco Model deve conter um id");

        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }


        return modelMapper.map(carrinhoModel, CarrinhoDto.class);
    }


    public CarrinhoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel carrinhoModel = new CarrinhoModel();
        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(carrinhoModel, CarrinhoDto.class);
    }

    public CarrinhoDto insert(CarrinhoDto carrinhoDto) {
        carrinhoDto.setId(null);

        CarrinhoDto result = new CarrinhoDto(carrinhoRepository.save(new CarrinhoModel(carrinhoDto)));

        return result;
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel) {

        return carrinhoRepository.save(carrinhoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }



    public CarrinhoDto buscarPorId(Long id) {

        Optional<CarrinhoModel> carrinhoModel = carrinhoRepository.buscaPorId(id);

        if (carrinhoModel.isPresent())
        {
            return new CarrinhoDto(carrinhoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }


    }
}




