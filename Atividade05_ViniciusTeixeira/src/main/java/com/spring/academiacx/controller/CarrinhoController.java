package com.spring.academiacx.controller;

import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.model.dto.CarrinhoDto;
import com.spring.academiacx.service.CarrinhoService;
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
    public CarrinhoDto findById(@PathVariable Long id) {

        return carrinhoService.findById(id);
    }
    @PostMapping("/salvar")
    public CarrinhoDto insert(@RequestBody CarrinhoDto carrinhoDto) {

        return carrinhoService.insert(carrinhoDto);
    }


    @PutMapping("/update")
    public CarrinhoModel update(@RequestBody CarrinhoModel carrinhoModel) {

        return carrinhoService.update(carrinhoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return carrinhoService.delete(id);
    }

    @GetMapping("/buscar-id")
    public CarrinhoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return carrinhoService.buscarPorId(id);
    }




}


