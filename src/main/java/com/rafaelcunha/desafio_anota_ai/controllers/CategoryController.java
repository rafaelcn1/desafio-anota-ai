package com.rafaelcunha.desafio_anota_ai.controllers;

import com.rafaelcunha.desafio_anota_ai.domain.category.Category;
import com.rafaelcunha.desafio_anota_ai.domain.category.CategoryDTO;
import com.rafaelcunha.desafio_anota_ai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.insert(categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Category> update(@PathParam("id") String id, @RequestBody CategoryDTO categoryData) {
        Category updateCategory = this.service.update(id, categoryData);
        return ResponseEntity.ok().body(updateCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam("id") String id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
