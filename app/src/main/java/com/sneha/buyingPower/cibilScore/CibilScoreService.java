package com.sneha.buyingPower.cibilScore;


public class CibilScoreService {
    private CibilScoreDatabase cibilScoreDatabase;

    CibilScoreService(CibilScoreDatabase cibilScoreDatabase){
        this.cibilScoreDatabase =cibilScoreDatabase;
    }
    public int getEnteries(String userId) {
        return cibilScoreDatabase.getCibilScore(userId);
    }
}
