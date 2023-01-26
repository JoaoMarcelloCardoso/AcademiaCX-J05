package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.dto.CarrinhoDto;
import com.demo.academiacx.model.dto.ProdutoDto;
import com.demo.academiacx.repository.CarrinhoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;
    private final ModelMapper modelMapper;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ModelMapper modelMapper) {
        this.carrinhoRepository = carrinhoRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarrinhoDto> findAll() {
        List<CarrinhoModel> CarrinhoModels = carrinhoRepository.findAll();

        return modelMapper.map(CarrinhoModels, new TypeToken<List<CarrinhoDto>>() {
        }.getType());    }

    public CarrinhoDto findById(CarrinhoModel CarrinhoModel) {

        if (CarrinhoModel == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve informada");

        }

        if (CarrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve conter um id");
        }

        try {
            CarrinhoModel = carrinhoRepository.findById(CarrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(CarrinhoModel, CarrinhoDto.class);
    }

    public CarrinhoDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel CarrinhoModel = new CarrinhoModel();
        try {
            CarrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(CarrinhoModel, CarrinhoDto.class);
    }

    public CarrinhoDto insert(CarrinhoDto carrinhoDto) {

        CarrinhoDto result = new CarrinhoDto(carrinhoRepository.save(new CarrinhoModel(carrinhoDto)));

        return result;
    }

    public CarrinhoModel update(CarrinhoModel CarrinhoModel) {

        findById(CarrinhoModel);


        return carrinhoRepository.save(CarrinhoModel);
    }

    public CarrinhoModel findModelById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel carrinhoModel = new CarrinhoModel();
        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            CarrinhoModel carrinhoModel = findModelById(id);
            try {
                carrinhoRepository.delete(carrinhoModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
}
