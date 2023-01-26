package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.CarrinhoModel;
import com.academiacx.models.dto.CarrinhoDto;
import com.academiacx.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<CarrinhoDto> carrinhos = carrinhoService.findAll();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }
        CarrinhoDto carrinhos = carrinhoService.findById(id);

        if(carrinhos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrinhos);
    }

    @PostMapping("/save")
    public ResponseEntity<CarrinhoDto> save(@Valid @RequestBody CarrinhoDto carrinhoDto){
        carrinhoService.save(carrinhoDto);
        return ResponseEntity.ok(carrinhoDto);
    }
    @PutMapping("/update")
    public ResponseEntity<CarrinhoDto> update(@Valid @RequestBody CarrinhoDto carrinhoDto){
        return ResponseEntity.ok(carrinhoService.update(carrinhoDto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<CarrinhoDto> delete(@Valid @RequestBody CarrinhoDto carrinhoDto){
        return ResponseEntity.ok(carrinhoService.delete(carrinhoDto));
    }


}












