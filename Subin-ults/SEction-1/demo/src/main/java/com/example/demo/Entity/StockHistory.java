package com.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class StockHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
