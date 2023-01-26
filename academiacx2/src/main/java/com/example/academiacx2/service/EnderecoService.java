package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.EnderecoModel;
import com.example.academiacx2.model.dto.EnderecoDto;
import com.example.academiacx2.repository.EnderecoRepository;
import com.example.academiacx2.utils.Validation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ModelMapper modelMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, ModelMapper modelMapper) {
        this.enderecoRepository = enderecoRepository;
        this.modelMapper = modelMapper;
    }

    public List<EnderecoDto> findall(){
        List<EnderecoModel> enderecoModels = enderecoRepository.findAll();

        return modelMapper.map(enderecoModels, new TypeToken<List<EnderecoDto>>(){
        }.getType());
    }

    public EnderecoDto findById(EnderecoModel enderecoModel) {

        if (enderecoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto findById(Long id) {

        if(id == null){
            throw  new ParametroInvalidoException("Id informado inválido");
        }

        EnderecoModel enderecoModel = new EnderecoModel();

        try {
            enderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(enderecoModel, EnderecoDto.class);
    }

    public EnderecoDto insert(EnderecoDto enderecoDto) {
        enderecoDto.setId(null);

        validarInsert(enderecoDto);

        EnderecoModel enderecoModel = enderecoRepository.save(modelMapper.map(enderecoDto, EnderecoModel.class));

        return modelMapper.map(enderecoModel,EnderecoDto.class);
    }

    public EnderecoModel update(EnderecoModel enderecoModel) {

        findById(enderecoModel);

        return enderecoRepository.save(enderecoModel);
    }

    public boolean delete(Long id){

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }

    public EnderecoModel findByCepAndUf(String cep, String uf) {

        Optional<List<EnderecoModel>> listEnderecoModel = enderecoRepository.findByCepOrUf(cep, uf);

        if (listEnderecoModel.isPresent()) {


            return listEnderecoModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
    }

    public EnderecoDto buscarPorId(Long id) {

        Optional<EnderecoModel> enderecoModel = enderecoRepository.buscaPorId(id);

        if (enderecoModel.isPresent())
        {
            return new EnderecoDto(enderecoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }
    }

    public void validarInsert(EnderecoDto enderecoDto){
        if(enderecoDto.getLogradouro() == null){
            throw new ParametroInvalidoException("Logradouro inválido, digite outro");
        }

        if(enderecoDto.getNumero() == null){
            throw new ParametroInvalidoException("Numero inválido, digite outro");
        }

        if(enderecoDto.getBairro() == null){
            throw new ParametroInvalidoException("Bairro inválido, digite outro");
        }

        if(enderecoDto.getCidade() == null){
            throw new ParametroInvalidoException("Cidade inválida, digite outro");
        }

        Validation.ufValidation(enderecoDto.getUf(),"Uf inválida, digite outro");

        if(enderecoDto.getCep() == null){
            throw new ParametroInvalidoException("Cep inválido, digite outro");
        }

        if(enderecoDto.getClienteModel() == null){
            throw new ParametroInvalidoException("Id do Cliente inválido, digite outro");
        }
    }

}
