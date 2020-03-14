package com.binio.dbmaster.controller;

import java.util.List;
import java.util.Optional;

import com.binio.dbmaster.model.Model;
import com.binio.dbmaster.model.Product;
import com.binio.dbmaster.repository.ModelRepository;
import com.binio.dbmaster.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/product")
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    ResponseEntity<Product> getProduct(@PathVariable("id") Short id) {
        if(productService.getProductById(id).equals(Optional.empty())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.of(productService.getProductById(id));
        }
    }

    @GetMapping(path="/model")
    public @ResponseBody
    ResponseEntity<Model> getModel(@RequestParam Byte id) {
        if(modelRepository.findById(id).equals(Optional.empty())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.of(modelRepository.findById(id));
        }
    }
}
