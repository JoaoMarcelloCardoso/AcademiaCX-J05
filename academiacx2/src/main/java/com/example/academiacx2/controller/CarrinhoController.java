package com.example.academiacx2.controller;

import com.example.academiacx2.model.CarrinhoModel;
import com.example.academiacx2.model.dto.CarrinhoDto;
import com.example.academiacx2.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CarrinhoModel> response =  carrinhoService.findall();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public CarrinhoDto findById(@PathVariable Long id){

        return carrinhoService.findById(id);
    }

    @PostMapping("/save")
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

    @GetMapping("/filter")
    public CarrinhoModel filter(@RequestParam(value = "datahora", required = true) LocalDateTime datahora,
                            @RequestParam(value = "total", required = false) Double total) {

        return carrinhoService.findByDatahoraAndTotal(datahora, total);
    }

    @GetMapping("/buscar-id")
    public CarrinhoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return carrinhoService.buscarPorId(id);
    }
}
