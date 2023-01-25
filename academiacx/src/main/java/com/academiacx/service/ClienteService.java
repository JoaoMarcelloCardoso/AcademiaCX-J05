package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ClienteModel;
import com.academiacx.model.dto.ClienteDto;
import com.academiacx.repository.ClienteRepository;
import com.academiacx.utils.ValidacaoUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteDto> findAll() {

        List<ClienteModel> clienteModels = clienteRepository.findAll();

        return modelMapper.map(clienteModels, new TypeToken<List<ClienteDto>>() {
        }.getType());
    }

    public ClienteDto findById(ClienteModel clienteModel) {

        if (clienteModel == null) {
            throw new ParametroInvalidoException("O Cliente Model deve ser informado!");
        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("O Cliente Model deve conter um id!");
        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(clienteModel, ClienteDto.class);
    }

    public ClienteDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ClienteModel clienteModel = new ClienteModel();
        try {
            clienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(clienteModel, ClienteDto.class);
    }

    public ClienteDto insert(ClienteDto clienteDto) {

        clienteDto.setId(null);

        validarCliente(clienteDto);

        clienteDto.setCpf(clienteDto.getCpf()
                .replace(".", "")
                .replace("-", ""));

        try {
            return new ClienteDto(clienteRepository.save(new ClienteModel(clienteDto)));
        } catch (Exception e) {
            throw new ConstraintViolationException("Algum dado inserido viola uma restrição do banco de dados (dado nulo ou já existente)");
        }
    }

    public ClienteDto update(ClienteDto clienteDto) {

        findById(new ClienteModel(clienteDto));

        validarCliente(clienteDto);

        clienteDto.setCpf(clienteDto.getCpf()
                .replace(".", "")
                .replace("-", ""));

        try {
            return new ClienteDto(clienteRepository.save(new ClienteModel(clienteDto)));
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado inserido viola uma restrição do banco de dados (dado nulo ou já existente)");
        }

    }

    public boolean delete(Long id) {

        findById(id);

        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }


    private void validarCliente(ClienteDto clienteDto) {
        ValidacaoUtils.validarVazio(clienteDto.getNome(), "O nome é obrigatório!");
        ValidacaoUtils.validarCpf(clienteDto.getCpf(), "O CPF inserido é inválido!");
    }
}
