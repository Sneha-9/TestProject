package com.sneha.queueSystem.store;

import com.sneha.queueSystem.queue.MessageQueue;

import java.util.HashMap;
import java.util.Map;

public class MessageQueueStore {
    private Map<String, MessageQueue> queueStore = new HashMap<>();

    public void add(String id, MessageQueue messageQueue){
        queueStore.put(id, messageQueue);
    }

    public MessageQueue get(String id){
        return queueStore.get(id);
    }
}
