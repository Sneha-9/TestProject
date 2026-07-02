package com.sneha.queueSystem.producer;

import com.sneha.queueSystem.dataModel.Message;
import com.sneha.queueSystem.queueSystem.MessageQueueSystem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProducerMessageProcessingSystem implements ProcessingSystem{

    private MessageQueueSystem messageQueueSystem;

    public void send(String queueId, Message message){
        messageQueueSystem.send(queueId, message);
    }
}
