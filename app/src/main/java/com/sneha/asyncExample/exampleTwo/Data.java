package com.sneha.asyncExample.exampleTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Data {
    private String value;

    @Override
    public String toString() {
        return "Data : { " + value + " }";
    }
}
