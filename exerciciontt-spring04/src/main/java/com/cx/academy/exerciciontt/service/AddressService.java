package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.dto.response.AddressDtoResponse;
import com.cx.academy.exerciciontt.model.dto.response.ClientDtoResponse;
import com.cx.academy.exerciciontt.repository.AdressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {

    @Autowired
    private AdressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<AddressDtoResponse> findAll() {
        try {
            List<AddressModel> addressList = addressRepository.findAll();
            if(addressList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint address");
            }
            return modelMapper.map(addressList, new TypeToken<List<AddressDtoResponse>>() {}.getType());
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar endereços");
        }
    }

    public AddressDtoResponse findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {

            AddressModel addressModel = addressRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Endereço não encontrado com o id informado"));
            return modelMapper.map(addressModel,AddressDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar endereço pelo id");
        }
    }

    public AddressDtoResponse findById(AddressModel addressModel) {
        if (addressModel == null) {
            throw new ParametroInvalidoException("A Address Model deve ser informada");
        }

        if (addressModel.getId() == null) {
            throw new ParametroInvalidoException("A Address Model deve conter um id");
        }

        try {
            AddressModel address=addressRepository.findById(addressModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Endereço não encontrado com o id informado"));
            return modelMapper.map(address,AddressDtoResponse.class);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar endereço pelo id");
        }
    }


    public AddressDtoResponse insert(AddressModel addressModel) {
        addressModel.setId(null);
        addressRepository.save(addressModel);

        return modelMapper.map(addressModel, AddressDtoResponse.class);
    }


    public AddressDtoResponse update(AddressModel addressModel) {
        if(!addressRepository.existsById(addressModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe endereço com o id informado");
        }

        try {
            addressRepository.save(addressModel);
            return modelMapper.map(addressModel,AddressDtoResponse.class);

        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar endereço");
        }
    }

    public boolean delete(Long id) {

        if(id == null || !addressRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe endereço com o id informado");
        }
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar endereço");
        }

    }
}
