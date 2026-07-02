package com.sneha.queueSystem.queueSystem;

import com.sneha.queueSystem.dataModel.Message;
import com.sneha.queueSystem.dataModel.QueueData;
import com.sneha.queueSystem.queue.MessageQueue;
import com.sneha.queueSystem.queue.Queue;
import com.sneha.queueSystem.queueGenerationSystem.MessageQueueGenerationSystem;
import com.sneha.queueSystem.queueGenerationSystem.QueueGenerationSystem;
import com.sneha.queueSystem.store.MessageQueueStore;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageQueueSystem {
   private MessageQueueGenerationSystem queueGenerationSystem;
   private MessageQueueStore messageQueueStore;


   public String generate(){
       MessageQueue queue = queueGenerationSystem.generate();
       messageQueueStore.add(queue.getId(),queue);
       return queue.getId();
   }

   public void send(String queueId, Message message){
       MessageQueue queue = messageQueueStore.get(queueId);
       queue.push(message);
    }

    public Message remove(String queueId){
        MessageQueue queue = messageQueueStore.get(queueId);
        if(queue == null)
            return null;
       return queue.poll();
    }
}
