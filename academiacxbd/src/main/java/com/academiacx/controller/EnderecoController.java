package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.EnderecoModel;
import com.academiacx.models.dto.EnderecoDto;
import com.academiacx.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<EnderecoDto> enderecos = enderecoService.findAll();
        return ResponseEntity.ok(enderecos);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        EnderecoDto enderecos = enderecoService.findById(id);

        if(enderecos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecos);

    }
    @PostMapping("/save")
    public ResponseEntity<EnderecoDto> save(@Valid @RequestBody EnderecoDto enderecoDto){
        enderecoService.save(enderecoDto);
        return ResponseEntity.ok(enderecoDto);
    }

    @PutMapping("/update")
    public ResponseEntity<EnderecoDto> update(@Valid @RequestBody EnderecoDto enderecoDto){
        return ResponseEntity.ok(enderecoService.update(enderecoDto));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<EnderecoDto> delete(@Valid @RequestBody EnderecoDto enderecoDto){
        return ResponseEntity.ok(enderecoService.delete(enderecoDto));
  }





}
