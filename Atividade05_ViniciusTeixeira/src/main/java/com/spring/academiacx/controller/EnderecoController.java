package com.spring.academiacx.controller;

import com.spring.academiacx.model.EnderecoModel;
import com.spring.academiacx.model.dto.EnderecoDto;
import com.spring.academiacx.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<EnderecoDto> response = enderecoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public EnderecoDto findById(@PathVariable Long id) {

        return enderecoService.findById(id);
    }
    @PostMapping("/salvar")
    public EnderecoDto insert(@RequestBody EnderecoDto enderecoDto) {

        return enderecoService.insert(enderecoDto);
    }


    @PutMapping("/update")
    public EnderecoModel update(@RequestBody EnderecoModel enderecoModel) {

        return enderecoService.update(enderecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return enderecoService.delete(id);
    }

    @GetMapping("/buscar-id")
    public EnderecoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return enderecoService.buscarPorId(id);
    }




}



