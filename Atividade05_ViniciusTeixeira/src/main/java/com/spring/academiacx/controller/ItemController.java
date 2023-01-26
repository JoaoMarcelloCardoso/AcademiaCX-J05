package com.spring.academiacx.controller;

import com.spring.academiacx.model.ItemModel;
import com.spring.academiacx.model.dto.ItemDto;
import com.spring.academiacx.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ItemDto> response = itemService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id) {

        return itemService.findById(id);
    }
    @PostMapping("/salvar")
    public ItemDto insert(@RequestBody ItemDto itemDto) {

        return itemService.insert(itemDto);
    }


    @PutMapping("/update")
    public ItemModel update(@RequestBody ItemModel itemModel) {

        return itemService.update(itemModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return itemService.delete(id);
    }

    @GetMapping("/buscar-id")
    public ItemDto filter(@RequestParam(value = "id", required = true) Long id) {

        return itemService.buscarPorId(id);
    }




}



