package com.example.demo.Repo;

import com.example.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCurrentStockLessThan(int i);
}
