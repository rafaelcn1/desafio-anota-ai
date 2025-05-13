package com.rafaelcunha.desafio_anota_ai.domain.category;

public record CategoryDTO(String title, String description, String ownerId) {
    public CategoryDTO(Category category) {
        this(category.getTitle(), category.getDescription(), category.getOwnerId());
    }
}
