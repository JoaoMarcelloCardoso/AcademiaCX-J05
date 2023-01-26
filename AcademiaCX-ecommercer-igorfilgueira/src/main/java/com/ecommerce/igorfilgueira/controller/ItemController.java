package com.ecommerce.igorfilgueira.controller;


import com.ecommerce.igorfilgueira.model.ItemModel;
import com.ecommerce.igorfilgueira.model.dto.ItemDto;
import com.ecommerce.igorfilgueira.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /*@GetMapping
    public ResponseEntity<?> findAll() {

        List<ItemModel> response = itemService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }*/

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id) {

        return itemService.findById(id);
    }

    /*@PostMapping("/save")
    public ItemModel insert(@RequestBody ItemModel itemModel) {

        return itemService.insert(itemModel);
    }*/

    @PutMapping("/update")
    public ItemDto update(@RequestBody ItemModel itemModel) {

        return itemService.update(itemModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return itemService.delete(id);
    }

}