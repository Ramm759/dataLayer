package com.openclassrooms.datalayer.service;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }


}
