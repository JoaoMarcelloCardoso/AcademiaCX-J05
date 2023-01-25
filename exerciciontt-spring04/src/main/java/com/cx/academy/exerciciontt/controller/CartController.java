package com.cx.academy.exerciciontt.controller;

import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.CartModel;
import com.cx.academy.exerciciontt.service.AddressService;
import com.cx.academy.exerciciontt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<CartModel
                > response = cartService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {

        CartModel response = cartService.findById(id);

        return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody CartModel cartModel) {

        CartModel response = cartService.insert(cartModel);

        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CartModel cartModel) {

        CartModel response = cartService.update(cartModel);

        return response == null? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) long id) {

        boolean success = cartService.delete(id);

        return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
