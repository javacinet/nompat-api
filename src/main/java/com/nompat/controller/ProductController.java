package com.nompat.controller;

import com.nompat.model.Product;
import com.nompat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.accepted().body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return product != null ?
                ResponseEntity.accepted().body(product) :
                ResponseEntity.badRequest().body(null);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity
                .accepted()
                .body(productService.add(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        product = productService.update(id, product);
        return product != null ?
                ResponseEntity.accepted().body(product) :
                ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return productService.delete(id) ?
                ResponseEntity.accepted().body(true) :
                ResponseEntity.badRequest().body(false);
    }

}
