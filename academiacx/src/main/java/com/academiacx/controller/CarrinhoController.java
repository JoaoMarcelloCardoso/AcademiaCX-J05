package com.academiacx.controller;

import com.academiacx.model.dto.CarrinhoDto;
import com.academiacx.service.CarrinhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<CarrinhoDto> response = carrinhoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        CarrinhoDto response = carrinhoService.findById(id);

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody CarrinhoDto carrinhoDto) {

        CarrinhoDto response = carrinhoService.insert(carrinhoDto);

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CarrinhoDto carrinhoDto) {

        CarrinhoDto response = carrinhoService.update(carrinhoDto);

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id") Long id) {

        return carrinhoService.delete(id);
    }


}
