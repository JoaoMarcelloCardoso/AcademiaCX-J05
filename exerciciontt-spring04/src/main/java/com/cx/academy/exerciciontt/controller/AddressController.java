package com.cx.academy.exerciciontt.controller;

import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.dto.response.AddressDtoResponse;
import com.cx.academy.exerciciontt.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<AddressDtoResponse> response = addressService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        AddressDtoResponse response = addressService.findById(id);

        return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody AddressModel addressModel) {

        AddressDtoResponse response = addressService.insert(addressModel);

        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AddressModel addressModel) {

        AddressDtoResponse response = addressService.update(addressModel);

        return response == null? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) long id) {

        boolean success = addressService.delete(id);

        return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
