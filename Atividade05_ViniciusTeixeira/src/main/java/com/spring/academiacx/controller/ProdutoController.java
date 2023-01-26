package com.spring.academiacx.controller;


import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.model.dto.ProdutoDto;
import com.spring.academiacx.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ProdutoDto> response = produtoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ProdutoDto findById(@PathVariable Long id) {

        return produtoService.findById(id);
    }
    @PostMapping("/salvar")
    public ProdutoDto insert(@RequestBody ProdutoDto produtoDto) {

        return produtoService.insert(produtoDto);
    }


    @PutMapping("/update")
    public ProdutoModel update(@RequestBody ProdutoModel produtoModel) {

        return produtoService.update(produtoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return produtoService.delete(id);
    }

    @GetMapping("/buscar-id")
    public ProdutoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return produtoService.buscarPorId(id);
    }




}
