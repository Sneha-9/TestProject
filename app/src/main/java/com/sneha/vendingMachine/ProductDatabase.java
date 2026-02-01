package com.sneha.vendingMachine;

import java.util.List;

public class ProductDatabase {
    private final List<Product> products;

    ProductDatabase(List<Product> products) {
        this.products = products;
    }

    Product getProduct(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
