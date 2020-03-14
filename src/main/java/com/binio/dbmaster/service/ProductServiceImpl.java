package com.binio.dbmaster.service;

import java.util.List;
import java.util.Optional;

import com.binio.dbmaster.model.Product;
import com.binio.dbmaster.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(final Short productId) {
            return productRepository.findById(productId);

    }
}
