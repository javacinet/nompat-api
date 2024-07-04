package com.nompat.service;

import com.nompat.model.Product;
import com.nompat.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product getById(Integer id) {
        return productRepository.getById(id);
    }

    public Product add(Product product) {
        return productRepository.add(product);
    }

    public Product update(Integer id, Product product) {
        return productRepository.update(id, product);
    }

    public Boolean delete(Integer id) {
        return productRepository.delete(id);
    }
}
