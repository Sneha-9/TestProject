package com.sneha.queueSystem.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter

public class Consumer {
    private String id;

    public Consumer(){
        this.id = UUID.randomUUID().toString();
    }
}
