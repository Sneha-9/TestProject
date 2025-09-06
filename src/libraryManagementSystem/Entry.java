package libraryManagementSystem;

import java.util.Objects;

public class Entry {
    private String cardId;
    private long startTime;

    public Entry(TimeUtil timeUtil, String cardId) throws IllegalArgumentException {
        if (cardId == null || cardId.isEmpty()) {
            throw new IllegalArgumentException("Card Id cannot be empty or null");
        }

        this.startTime = timeUtil.getCurrentTime();
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public long getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return startTime == entry.startTime && Objects.equals(cardId, entry.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, startTime);
    }
}
