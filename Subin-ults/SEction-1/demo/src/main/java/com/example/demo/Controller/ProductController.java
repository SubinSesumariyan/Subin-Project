package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product>saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);
    }

    @GetMapping("/lowstock")
    public ResponseEntity<List<Product>> getLow(){
        return new ResponseEntity<>(productService.getLow(),HttpStatus.OK);
    }

    @GetMapping("/restocksug/{id}")
    public ResponseEntity<String> getSug(@PathVariable Long id){
        return new ResponseEntity<>(productService.getSug(id),HttpStatus.OK);
    }
}
