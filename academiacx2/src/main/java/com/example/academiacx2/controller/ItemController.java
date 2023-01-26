package com.example.academiacx2.controller;

import com.example.academiacx2.model.ItemModel;
import com.example.academiacx2.model.dto.ItemDto;
import com.example.academiacx2.service.ItemService;
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
    public ResponseEntity<?> findAll(){
        List<ItemDto> response =  itemService.findall();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id){

        return itemService.findById(id);
    }

    @PostMapping("/save")
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

    @GetMapping("/filter")
    public ItemModel filter(@RequestParam(value = "quantidade", required = true) Integer quantidade,
                            @RequestParam(value = "total", required = false) Double total) {

        return itemService.findByQuantidadeAndTotal(quantidade, total);
    }

    @GetMapping("/buscar-id")
    public ItemDto filter(@RequestParam(value = "id", required = true) Long id) {

        return itemService.buscarPorId(id);
    }
}
