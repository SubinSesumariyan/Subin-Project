package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repo.ProductRepository;
import com.example.demo.Repo.StockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockHistoryRepository stockHistoryRepository;
    public List<Product> getLow() {
        return productRepository.findByCurrentStockLessThan(10);
    }

    public String getSug(Long id) {
        Product product=productRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Product not found"));
        if(product.getCurrentStock()<product.getMinStock()){
            return "Restock need "+ product.getName();
        }
        else{
            return "Restock no need";
        }
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);

    }

    public Product updateProduct(Long id, Product product) {
        Product product1= productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        product1.setName(product.getName());
        product1.setCurrentStock(product.getCurrentStock());
        product1.setCategory(product.getCategory());
        product1.setMinStock(product.getMinStock());
        return productRepository.save(product1);
    }
}
