package com.cx.academy.exerciciontt.controller;

import com.cx.academy.exerciciontt.model.ProductModel;
import com.cx.academy.exerciciontt.model.dto.response.ProductDtoResponse;
import com.cx.academy.exerciciontt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping(value = "/product")
    public class ProductController {
        @Autowired
        private ProductService productService;

        @GetMapping
        public ResponseEntity<?> findAll() {

            List<ProductDtoResponse> response = productService.findAll();

            return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable long id) {

            ProductDtoResponse response = productService.findById(id);

            return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
        }

        @PostMapping("/save")
        public ResponseEntity<?> insert(@RequestBody ProductModel productModel) {

            ProductDtoResponse response = productService.insert(productModel);

            return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
        }

        @PutMapping("/update")
        public ResponseEntity<?> update(@RequestBody ProductModel productModel) {

            ProductDtoResponse response = productService.update(productModel);

            return response == null? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
        }

        @DeleteMapping("/delete")
        public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) long id) {

            boolean success = productService.delete(id);

            return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        }


    }
