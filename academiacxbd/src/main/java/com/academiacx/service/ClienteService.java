package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.ClienteModel;
import com.academiacx.models.dto.ClienteDto;
import com.academiacx.models.dto.managed.ManagedClienteDto;
import com.academiacx.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public List<ClienteDto> findAll(){
        List<ClienteModel> clienteModelList = clienteRepository.findAll();
        return modelMapper.map(clienteModelList, new TypeToken<List<ClienteDto>>(){}.getType());

    }

    public ClienteDto findById(Long id) {

        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            ClienteModel clienteMapper = clienteRepository.findById(id).get();
            return modelMapper.map(clienteMapper, ClienteDto.class);

        }
        return null;
    }

    public ClienteDto save(ManagedClienteDto clienteManaged) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setPassword(passwordEncoder.encode(clienteManaged.getPassword()));
        clienteModel.setCpf(clienteManaged.getCpf());
        clienteModel.setNome(clienteManaged.getNome());
        clienteRepository.save(clienteModel);

        return modelMapper.map(clienteModel, ClienteDto.class);
    }

    public ClienteDto update(ManagedClienteDto clienteManaged){
        Optional<ClienteModel> cliente = clienteRepository.findByCpf(clienteManaged.getCpf());
        if (cliente.isPresent()){
            ClienteModel clienteModel = cliente.get();
            clienteModel.setPassword(passwordEncoder.encode(clienteManaged.getPassword()));
            clienteModel.setCpf(clienteManaged.getCpf());
            clienteModel.setNome(clienteManaged.getNome());

            clienteRepository.save(clienteModel);
            return modelMapper.map(clienteModel, ClienteDto.class);
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public ClienteDto delete(ClienteDto clienteDto){
        try {
            Optional<ClienteModel> cliente = clienteRepository.findByCpf(clienteDto.getCpf());
            if (cliente.isPresent()) {
                ClienteModel clienteModel = cliente.get();
                clienteRepository.delete(clienteModel);
                return modelMapper.map(clienteModel, ClienteDto.class);
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
