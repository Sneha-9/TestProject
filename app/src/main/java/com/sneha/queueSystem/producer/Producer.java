package com.sneha.queueSystem.producer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Producer {
    private String id;

    public Producer(){
        this.id = UUID.randomUUID().toString();
    }
}
