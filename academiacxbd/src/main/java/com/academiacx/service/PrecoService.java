package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.PrecoModel;
import com.academiacx.models.dto.PrecoDto;
import com.academiacx.repository.PrecoRepository;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

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

    public List<PrecoDto> findAll(){
        List<PrecoModel> precoModelList = precoRepository.findAll();
        return modelMapper.map(precoModelList, new TypeToken<List<PrecoDto>>(){}.getType());

    }

    public PrecoDto findById(Long id) {

        Optional<PrecoModel> preco = precoRepository.findById(id);
        if (preco.isPresent()) {
            PrecoModel precoMapper = precoRepository.findById(id).get();
            return modelMapper.map(precoMapper, PrecoDto.class);

        }
        return null;
    }

    public PrecoDto save(PrecoDto precoDto) {
        PrecoModel precoModel = new PrecoModel();
        precoModel.setValor((precoDto.getValor()));
        precoRepository.save(precoModel);

        return modelMapper.map(precoModel, PrecoDto.class);
    }

    public PrecoDto update(PrecoDto precoDto){
        Optional<PrecoModel> preco = precoRepository.findById(precoDto.getId());
        if (preco.isPresent()){
            PrecoModel precoModel = preco.get();
            precoModel.setValor(precoDto.getValor());

            precoRepository.save(precoModel);
            return modelMapper.map(precoModel, PrecoDto.class);
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public PrecoDto delete(PrecoDto precoDto){
        try {
            Optional<PrecoModel> preco = precoRepository.findById(precoDto.getId());
            if (preco.isPresent()) {
                PrecoModel precoModel = preco.get();
                precoRepository.delete(precoModel);
                return modelMapper.map(precoModel, PrecoDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}