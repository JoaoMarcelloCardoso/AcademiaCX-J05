package com.spring.academiacx.controller;

import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.model.dto.PrecoDto;
import com.spring.academiacx.service.PrecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {

    private final PrecoService precoService;

    public PrecoController(PrecoService precoService) {
        this.precoService = precoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<PrecoDto> response = precoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public PrecoDto findById(@PathVariable Long id) {

        return precoService.findById(id);
    }
    @PostMapping("/salvar")
    public PrecoDto insert(@RequestBody PrecoDto precoDto) {

        return precoService.insert(precoDto);
    }


    @PutMapping("/update")
    public PrecoModel update(@RequestBody PrecoModel precoModel) {

        return precoService.update(precoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return precoService.delete(id);
    }

    @GetMapping("/buscar-id")
    public PrecoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return precoService.buscarPorId(id);
    }




}



