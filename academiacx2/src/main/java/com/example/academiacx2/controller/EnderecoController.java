package com.example.academiacx2.controller;

import com.example.academiacx2.model.EnderecoModel;
import com.example.academiacx2.model.dto.EnderecoDto;
import com.example.academiacx2.service.EnderecoService;
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
    public ResponseEntity<?> findAll(){
        List<EnderecoDto> response =  enderecoService.findall();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public EnderecoDto findById(@PathVariable Long id){

        return enderecoService.findById(id);
    }

    @PostMapping("/save")
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

    @GetMapping("/filter")
    public EnderecoModel filter(@RequestParam(value = "cep", required = true) String cep,
                            @RequestParam(value = "uf", required = false) String uf) {

        return enderecoService.findByCepAndUf(cep, uf);
    }

    @GetMapping("/buscar-id")
    public EnderecoDto filter(@RequestParam(value = "id", required = true) Long id) {

        return enderecoService.buscarPorId(id);
    }
}
