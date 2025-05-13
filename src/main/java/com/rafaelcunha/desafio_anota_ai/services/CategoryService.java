package com.rafaelcunha.desafio_anota_ai.services;

import com.rafaelcunha.desafio_anota_ai.domain.category.Category;
import com.rafaelcunha.desafio_anota_ai.domain.category.CategoryDTO;
import com.rafaelcunha.desafio_anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.rafaelcunha.desafio_anota_ai.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category category = new Category(categoryData);
        return this.repository.save(category);
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if (!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if (!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        this.repository.save(category);
        return category;
    }

    public void delete(String id) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(category);
    }
}
