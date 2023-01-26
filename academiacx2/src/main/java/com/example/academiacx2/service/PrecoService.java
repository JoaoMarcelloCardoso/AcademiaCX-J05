package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.PrecoModel;
import com.example.academiacx2.model.dto.PrecoDto;
import com.example.academiacx2.repository.PrecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecoService {

    private final PrecoRepository precoRepository;
    private final ModelMapper modelMapper;

    public PrecoService(PrecoRepository precoRepository, ModelMapper modelMapper) {
        this.precoRepository = precoRepository;
        this.modelMapper = modelMapper;
    }

    public List<PrecoDto> findall(){
        List<PrecoModel> precoModels = precoRepository.findAll();

        return modelMapper.map(precoModels, new TypeToken<List<PrecoDto>>(){
        }.getType());
    }

    public PrecoDto findById(PrecoModel precoModel) {

        if (precoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            precoModel = precoRepository.findById(precoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto findById(Long id) {

        if(id == null){
            throw  new ParametroInvalidoException("Id informado inválido");
        }

        PrecoModel precoModel = new PrecoModel();

        try {
            precoModel = precoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto insert(PrecoDto precoDto) {
        precoDto.setId(null);

        validarInsert(precoDto);

        PrecoModel precoModel = precoRepository.save(modelMapper.map(precoDto, PrecoModel.class));

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoModel update(PrecoModel precoModel) {

        findById(precoModel);

        return precoRepository.save(precoModel);
    }

    public boolean delete(Long id){

        findById(id);

        precoRepository.deleteById(id);

        return true;
    }

    public PrecoModel findByValorAndId(Double valor, Long id) {

        Optional <List<PrecoModel>> listPrecoModel = precoRepository.findByValorOrId(valor, id);

        if (listPrecoModel.isPresent()) {


            return listPrecoModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
    }

    public PrecoDto buscarPorId(Long id) {

        Optional<PrecoModel> precoModel = precoRepository.buscaPorId(id);

        if (precoModel.isPresent())
        {
            return new PrecoDto(precoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }
    }

    public void validarInsert(PrecoDto precoDto){
        if(precoDto.getValor() == null){
            throw new ParametroInvalidoException("Valor inválido, digite outro");
        }

        if(precoDto.getClienteModel() == null){
            throw new ParametroInvalidoException("Id do cliente inválido, digite outro");
        }

        if(precoDto.getProdutoModel() == null){
            throw new ParametroInvalidoException("Id do produto inválido, digite outro");
        }
    }
}
