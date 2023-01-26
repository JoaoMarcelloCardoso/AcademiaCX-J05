package com.demo.academiacx.controller;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.dto.ClienteDto;
import com.demo.academiacx.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService ClienteService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ClienteDto> response = ClienteService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ClienteDto findById(@PathVariable Long id) {

        return ClienteService.findById(id);
    }

    @PostMapping("/save")
    public ClienteDto insert(@RequestBody ClienteDto ClienteDto) {

        return ClienteService.insert(ClienteDto);
    }


    @PutMapping("/update")
    public ClienteModel update(@RequestBody ClienteModel ClienteModel) {

        return ClienteService.update(ClienteModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return ClienteService.delete(id);
    }
}
