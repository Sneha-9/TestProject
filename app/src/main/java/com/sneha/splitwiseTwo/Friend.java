package com.sneha.splitwiseTwo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Friend {
    private String id;
    Friend(){
        this.id= UUID.randomUUID().toString();
    }
}
