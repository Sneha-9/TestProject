package com.sneha.queueSystem.queueGenerationSystem;

import com.sneha.queueSystem.queue.MessageQueue;
import com.sneha.queueSystem.queue.Queue;

public class MessageQueueGenerationSystem implements QueueGenerationSystem{

    public MessageQueue generate(){
        return new MessageQueue();
    }
}
