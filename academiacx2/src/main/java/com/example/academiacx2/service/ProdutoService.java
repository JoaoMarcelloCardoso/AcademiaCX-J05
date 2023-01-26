package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.ProdutoModel;
import com.example.academiacx2.model.dto.ProdutoDto;
import com.example.academiacx2.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository,ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProdutoDto> findall(){
        List<ProdutoModel> produtoModels = produtoRepository.findAll();

        return modelMapper.map(produtoModels, new TypeToken<List<ProdutoDto>>(){
        }.getType());
    }

    public ProdutoDto findById(ProdutoModel produtoModel) {

        if (produtoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto findById(Long id) {

        if(id == null){
            throw  new ParametroInvalidoException("Id informado inválido");
        }

        ProdutoModel produtoModel = new ProdutoModel();

        try {
            produtoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoDto insert(ProdutoDto produtoDto) {
        produtoDto.setId(null);

        validarInsert(produtoDto);

        ProdutoModel produtoModel = produtoRepository.save(modelMapper.map(produtoDto, ProdutoModel.class));

        return modelMapper.map(produtoModel, ProdutoDto.class);
    }

    public ProdutoModel update(ProdutoModel produtoModel) {

        findById(produtoModel);

        return produtoRepository.save(produtoModel);
    }

    public boolean delete(Long id){

        findById(id);

        produtoRepository.deleteById(id);

        return true;
    }

    public ProdutoModel findBySkuAndNome(String sku, String nome) {

        Optional<List<ProdutoModel>> listUserModel = produtoRepository.findBySkuOrNome(sku, nome);

        if (listUserModel.isPresent()) {


            return listUserModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
    }

    public ProdutoDto buscarPorId(Long id) {

        Optional<ProdutoModel> produtoModel = produtoRepository.buscaPorId(id);

        if (produtoModel.isPresent())
        {
            return new ProdutoDto(produtoModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }
    }

    public void validarInsert(ProdutoDto produtoDto){
        if(produtoDto.getNome() == null){
            throw new ParametroInvalidoException("Nome inválido, digite outro");
        }

        if(produtoDto.getSku() == null){
            throw new ParametroInvalidoException("SKU inválido, digite outro");
        }
    }
}