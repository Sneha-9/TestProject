package com.sneha.asyncExample.exampleOne;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Data {
    private String value;
    private String id;

    public Data(String value){
        this.value = value;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Data" + ": " + value;
    }
}
