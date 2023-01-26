package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.SenhaInvalidaException;
import com.academiacx.models.ClienteModel;
import com.academiacx.models.dto.ClienteDto;
import com.academiacx.models.dto.managed.ManagedClienteDto;
import com.academiacx.service.ClienteService;
import com.academiacx.utils.InterfaceUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/findAll")
    public ResponseEntity<List<ClienteDto>> findAll(){

        List<ClienteDto> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        ClienteDto clientes = clienteService.findById(id);

        if(clientes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);

    }
    @PostMapping("/save")
    public ResponseEntity<ClienteDto> save(@Valid @RequestBody ManagedClienteDto clienteManaged) throws SenhaInvalidaException {
         InterfaceUtils.validatePassword(clienteManaged.getPassword());
        boolean isCpfValid = InterfaceUtils.validateCPF(clienteManaged.getCpf());

        if(isCpfValid) {
            clienteService.save(clienteManaged);
            return ResponseEntity.ok(clienteManaged);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteDto> update(@Valid @RequestBody ManagedClienteDto clienteManaged){
        clienteService.update(clienteManaged);
        return ResponseEntity.ok(clienteManaged);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ClienteDto> delete(@Valid @RequestBody ClienteDto clienteDto){

        return ResponseEntity.ok(clienteService.delete(clienteDto));

    }





}
