package com.sneha.vendingMachine;

public class VendingMachine {
    private ProductDatabase productDatabase;
    private VendingMachineDatabasee vendingMachineDatabasee;
    VendingMachine(ProductDatabase productDatabase, VendingMachineDatabasee vendingMachineDatabasee){
        this.productDatabase=productDatabase;
        this.vendingMachineDatabasee=vendingMachineDatabasee;
    }


    Product getProduct(Amount amount, int productNumber){
        Record record= vendingMachineDatabasee.getRecord(productNumber);
        if(record == null){
            throw new IllegalArgumentException("No product found");
        }

        if(record.getQuantity() <=0){
            throw  new RuntimeException("Product is out of stock");
        }

        Product product = productDatabase.getProduct(record.getProductId());
        if(product == null){
            throw  new RuntimeException("Internal error");
        }

        vendingMachineDatabasee.updateRecord(productNumber);
        return  product;
    }
}
