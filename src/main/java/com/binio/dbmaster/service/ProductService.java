package com.binio.dbmaster.service;

import java.util.List;
import java.util.Optional;

import com.binio.dbmaster.model.Product;

public interface ProductService {
    public List<Product> getProducts();
    public Optional<Product> getProductById(Short productId);
}
