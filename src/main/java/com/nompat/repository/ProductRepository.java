package com.nompat.repository;

import com.nompat.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private static Integer idGenerator = 0;

    private List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product getById(Integer id) {
        Optional<Product> optional = findById(id);
        return optional.orElse(null);
    }

    public Product add(Product product) {
        product.setId(++idGenerator);
        products.add(product);
        return product;
    }

    public Product update(Integer id, Product product) {
        Optional<Product> optional = findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Product productInDB = optional.get();
        if (product.getName() != null) {
            productInDB.setName(product.getName());
        }
        if (product.getCreatedDate() != null) {
            productInDB.setCreatedDate(product.getCreatedDate());
        }
        if (product.getActive() != null) {
            productInDB.setActive(product.getActive());
        }

        return productInDB;
    }

    public Boolean delete(Integer id) {
        Optional<Product> optional = findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        products.remove(optional.get());
        return true;
    }

    private Optional<Product> findById(Integer id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
