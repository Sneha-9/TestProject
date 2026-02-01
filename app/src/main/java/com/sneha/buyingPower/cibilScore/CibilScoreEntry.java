package com.sneha.buyingPower.cibilScore;

public class CibilScoreEntry {
    private String id;
    private  String userId;
    private  int score;

    CibilScoreEntry(String id,String userId, int score) {
        this.id= id;
        this.score = score;
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }
}
