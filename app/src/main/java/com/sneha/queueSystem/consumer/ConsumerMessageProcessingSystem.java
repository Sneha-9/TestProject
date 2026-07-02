package com.sneha.queueSystem.consumer;

import com.sneha.queueSystem.dataModel.Message;
import com.sneha.queueSystem.producer.ProcessingSystem;
import com.sneha.queueSystem.queueSystem.MessageQueueSystem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsumerMessageProcessingSystem implements ProcessingSystem {
    private MessageQueueSystem messageQueueSystem;

   public void receiveMessage(String queueId){
       Message message =  messageQueueSystem.remove(queueId);
       if(message == null){
           System.out.println("Message empty");
           return;
       }
       System.out.println("Message received" + message.getValue());
    }


}
