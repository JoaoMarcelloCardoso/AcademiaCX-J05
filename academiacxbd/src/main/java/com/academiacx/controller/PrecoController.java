package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.PrecoModel;
import com.academiacx.models.dto.PrecoDto;
import com.academiacx.service.PrecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {
    @Autowired
    private PrecoService precoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<PrecoDto> precos = precoService.findAll();
        return ResponseEntity.ok(precos);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        PrecoDto precos = precoService.findById(id);

        if(precos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(precos);

    }
    @PostMapping("/save")
    public ResponseEntity<PrecoDto> save(@Valid @RequestBody PrecoDto precoDto){
        precoService.save(precoDto);
        return ResponseEntity.ok(precoDto);
    }

    @PutMapping("/update")
    public ResponseEntity<PrecoDto> update(@Valid @RequestBody PrecoDto precoDto){
        return ResponseEntity.ok(precoService.update(precoDto));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<PrecoDto> delete(@Valid @RequestBody PrecoDto precoDto){
        return ResponseEntity.ok(precoService.delete(precoDto));
    }





}
