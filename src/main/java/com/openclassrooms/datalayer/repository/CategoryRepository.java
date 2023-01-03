package com.openclassrooms.datalayer.repository;

import com.openclassrooms.datalayer.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
