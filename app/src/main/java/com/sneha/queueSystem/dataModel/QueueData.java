package com.sneha.queueSystem.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueueData {
    private String queueId;
    private Message message;
}
