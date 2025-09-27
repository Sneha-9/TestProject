package com.sneha.vendingMachine;

import java.util.List;

public class VendingMachineDatabasee {
    private List<Record> records;

    VendingMachineDatabasee(List<Record> records){
        this.records =records;
    }


    Record getRecord(int productNumber){
        for(Record record: records){
            if(record.getProductNumber() == productNumber){
                return  record;
            }
        }

         return null;
    }

    void updateRecord(int productNumber){
        for(Record record: records){
            if(record.getProductNumber() == productNumber){
               record.decrementQuantity();
            }
        }
    }
}
