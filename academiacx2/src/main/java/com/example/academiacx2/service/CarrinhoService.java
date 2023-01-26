package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.CarrinhoModel;
import com.example.academiacx2.model.dto.CarrinhoDto;
import com.example.academiacx2.repository.CarrinhoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<CarrinhoModel> findall(){
        List<CarrinhoModel> carrinhoModels = carrinhoRepository.findAll();

        return modelMapper.map(carrinhoModels, new TypeToken<List<CarrinhoDto>>(){
        }.getType());
    }

    public CarrinhoDto findById(CarrinhoModel carrinhoModel) {

        if (carrinhoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(carrinhoModel, CarrinhoDto.class);
    }

    public CarrinhoDto findById(Long id) {

        if(id == null){
            throw  new ParametroInvalidoException("Id informado inválido");
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

        validarInsert(carrinhoDto);

        CarrinhoModel carrinhoModel = carrinhoRepository.save(modelMapper.map(carrinhoDto, CarrinhoModel.class));

        return modelMapper.map(carrinhoModel,CarrinhoDto.class);
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel) {

        findById(carrinhoModel);


        return carrinhoRepository.save(carrinhoModel);
    }

    public boolean delete(Long id){

        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }

    public CarrinhoModel findByDatahoraAndTotal(LocalDateTime datahora, Double total) {

        Optional<List<CarrinhoModel>> listCarrinhoModel = carrinhoRepository.findByDatahoraOrTotal(datahora, total);

        if (listCarrinhoModel.isPresent()) {


            return listCarrinhoModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
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

    public void validarInsert(CarrinhoDto carrinhoDto){
        if(carrinhoDto.getDatahora() == null){
            throw new ParametroInvalidoException("Horário e Data inválidos, digite outro");
        }

        if(carrinhoDto.getTotal() == null){
            throw new ParametroInvalidoException("Valor Total inválido, digite outro");
        }

        if(carrinhoDto.getClienteModel() == null){
            throw new ParametroInvalidoException("Id do Cliente inválido, digite outro");
        }
    }
}
