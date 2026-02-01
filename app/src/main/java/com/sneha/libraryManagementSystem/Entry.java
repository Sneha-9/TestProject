package com.sneha.libraryManagementSystem;

public class Entry {
    /**
     * @throws IllegalArgumentException
     */
    long startTime;
     String cardId;
    public Entry(TimeUtil startTime, String cardId) {
        if (cardId == null || cardId.isEmpty()) {
            throw new IllegalArgumentException("Card Id cannot be empty or null");
        }

        this.startTime = startTime.getCurrentTime();
        this.cardId = cardId;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getCardId() {
        return cardId;
    }
}
