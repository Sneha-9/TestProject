package com.sneha.queueSystem.queue;

import com.sneha.queueSystem.dataModel.Message;
import com.sneha.queueSystem.dataModel.QueueData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

@Getter

public class MessageQueue implements com.sneha.queueSystem.queue.Queue {
    private String id;
    private Queue<Message> queue = new LinkedList<>();

    public MessageQueue(){
        this.id = UUID.randomUUID().toString();
    }

    public void push(Message message){
        queue.add(message);
    }

    public Message poll(){
        if(queue.isEmpty()){
            return null;
        }
      return  queue.remove();
    }

    public String getId() {
        return id;
    }


}
