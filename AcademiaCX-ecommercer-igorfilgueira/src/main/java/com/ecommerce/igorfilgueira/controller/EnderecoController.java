package com.ecommerce.igorfilgueira.controller;

import com.ecommerce.igorfilgueira.model.EnderecoModel;
import com.ecommerce.igorfilgueira.model.dto.EnderecoDto;
import com.ecommerce.igorfilgueira.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    /*@GetMapping
    public ResponseEntity<?> findAll() {

        List<EnderecoModel> response = enderecoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }*/

    @GetMapping("/{id}")
    public EnderecoDto findById(@PathVariable Long id) {

        return enderecoService.findById(id);
    }

    /*@PostMapping("/save")
    public EnderecoModel insert(@RequestBody EnderecoModel enderecoModel) {

        return enderecoService.insert(enderecoModel);
    }*/

    @PutMapping("/update")
    public EnderecoDto update(@RequestBody EnderecoModel enderecoModel) {

        return enderecoService.update(enderecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return enderecoService.delete(id);
    }

}