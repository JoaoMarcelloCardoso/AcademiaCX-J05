package com.cx.academy.exerciciontt.controller;


import com.cx.academy.exerciciontt.model.ItemModel;
import com.cx.academy.exerciciontt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ItemModel> response = itemService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        ItemModel response = itemService.findById(id);

        return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody ItemModel itemModel) {

        ItemModel response = itemService.insert(itemModel);

        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ItemModel itemModel) {

        ItemModel response = itemService.update(itemModel);

        return response == null? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) long id) {

        boolean success = itemService.delete(id);

        return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
