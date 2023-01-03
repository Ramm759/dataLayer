package com.openclassrooms.datalayer.service;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
