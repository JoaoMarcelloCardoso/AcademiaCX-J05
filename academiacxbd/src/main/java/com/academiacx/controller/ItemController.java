package com.academiacx.controller;

import com.academiacx.models.ItemModel;
import com.academiacx.models.dto.ItemDto;
import com.academiacx.service.ItemService;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<ItemDto> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        ItemDto items = itemService.findById(id);

        if (items == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);

    }

    @PostMapping("/save")
    public ResponseEntity<ItemDto> save(@Valid @RequestBody ItemDto itemDto) {
        itemService.save(itemDto);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemDto> update(@Valid @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.update(itemDto));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ItemDto> delete(@Valid @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.delete(itemDto));
    }
}


