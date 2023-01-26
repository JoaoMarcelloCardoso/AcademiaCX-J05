package com.ecommerce.igorfilgueira.controller;

import com.ecommerce.igorfilgueira.model.ClienteModel;
import com.ecommerce.igorfilgueira.model.dto.ClienteDto;
import com.ecommerce.igorfilgueira.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    /*@GetMapping
    public ResponseEntity<?> findAll() {

        List<ClienteModel> response = clienteService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }*/

    @GetMapping("/{id}")
    public ClienteDto findById(@PathVariable Long id) {

        return clienteService.findById(id);
    }

    /*@PostMapping("/save")
    public ClienteModel insert(@RequestBody ClienteModel clienteModel) {

        return clienteService.insert(clienteModel);
    }*/


    @PutMapping("/update")
    public ClienteDto update(@RequestBody ClienteModel clienteModel) {

        return clienteService.update(clienteModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return clienteService.delete(id);
    }

}