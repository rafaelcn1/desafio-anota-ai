package com.rafaelcunha.desafio_anota_ai.domain.repositories;

import com.rafaelcunha.desafio_anota_ai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
