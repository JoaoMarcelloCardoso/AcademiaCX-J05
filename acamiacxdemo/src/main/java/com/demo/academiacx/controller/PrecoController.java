package com.demo.academiacx.controller;

import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.dto.CarrinhoDto;
import com.demo.academiacx.model.dto.PrecoDto;
import com.demo.academiacx.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preco")
public class PrecoController {
    @Autowired
    private PrecoService PrecoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<PrecoDto> response = PrecoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public PrecoDto findById(@PathVariable Long id) {

        return PrecoService.findById(id);
    }

    @PostMapping("/save")
    public PrecoDto insert(@RequestBody PrecoDto precoDto) {

        return PrecoService.insert(precoDto);
    }


    @PutMapping("/update")
    public PrecoModel update(@RequestBody PrecoModel PrecoModel) {

        return PrecoService.update(PrecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return PrecoService.delete(id);
    }
}
