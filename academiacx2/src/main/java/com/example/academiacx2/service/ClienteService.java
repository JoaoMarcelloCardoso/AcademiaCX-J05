package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.ClienteModel;
import com.example.academiacx2.model.dto.ClienteDto;
import com.example.academiacx2.repository.ClienteRepository;
import com.example.academiacx2.utils.Validation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteDto> findall(){
        List<ClienteModel> clienteModels = clienteRepository.findAll();

        return modelMapper.map(clienteModels, new TypeToken<List<ClienteDto>>(){
        }.getType());
    }

    public ClienteDto findById(ClienteModel clienteModel) {

        if (clienteModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(clienteModel, ClienteDto.class);
    }

    public ClienteDto findById(Long id) {

        if(id == null){
            throw  new ParametroInvalidoException("Id informado inválido");
        }

        ClienteModel clienteModel = new ClienteModel();

        try {
            clienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return modelMapper.map(clienteModel, ClienteDto.class);
    }

    public ClienteDto insert(ClienteDto clienteDto) {
        clienteDto.setId(null);

        validarInsert(clienteDto);

        ClienteModel clienteModel = clienteRepository.save(modelMapper.map(clienteDto, ClienteModel.class));

        return modelMapper.map(clienteModel,ClienteDto.class);
    }

    public ClienteModel update(ClienteModel clienteModel) {

        findById(clienteModel);

        return clienteRepository.save(clienteModel);
    }

    public boolean delete(Long id){

        findById(id);

        clienteRepository.deleteById(id);

        return true;
    }
    public ClienteModel findByCpfAndNome(String cpf, String nome) {

        Optional<List<ClienteModel>> listClienteModel = clienteRepository.findByCpfOrNome(cpf, nome);

        if (listClienteModel.isPresent()) {


            return listClienteModel.stream().findFirst().get().get(0);
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
    }

    public ClienteDto buscarPorId(Long id) {

        Optional<ClienteModel> clienteModel = clienteRepository.buscaPorId(id);

        if (clienteModel.isPresent())
        {
            return new ClienteDto(clienteModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }
    }

    public void validarInsert(ClienteDto clienteDto){

        Validation.cpfValidation(clienteDto.getCpf(),"Cpf inválido, digite outro");

        if(clienteDto.getNome() == null){
            throw new ParametroInvalidoException("Nome inválido, digite outro");

        }

        if(clienteDto.getUsername() == null){
            throw new ParametroInvalidoException("Username inválido, digite outro");
        }

        if(clienteDto.getPassword() == null){
            throw new ParametroInvalidoException("Senha inválida, digite outro");
        }

        if(clienteRepository.findByUsername(clienteDto.getUsername()).isPresent()){
            throw new ParametroInvalidoException("Esse Username já existe, digite outro");
        }
    }
}
