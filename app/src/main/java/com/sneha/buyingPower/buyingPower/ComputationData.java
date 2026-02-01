package com.sneha.buyingPower.buyingPower;

import com.sneha.buyingPower.collateral.CollateralEntry;
import com.sneha.buyingPower.income.IncomeEntry;
import com.sneha.buyingPower.loan.LoanEntry;

import java.util.List;

public class ComputationData {
    private final String userId;
    private final int cibilScore;
    private final List<IncomeEntry> incomes;
    private final List<LoanEntry> loans;
    private final List<CollateralEntry> collaterals;

    ComputationData(String userId, int cibilScore, List<IncomeEntry> incomes, List<LoanEntry> loans, List<CollateralEntry> collaterals) {
        this.collaterals = collaterals;
        this.incomes = incomes;
        this.loans = loans;
        this.userId = userId;
        this.cibilScore = cibilScore;
    }

    public String getUserId() {
        return userId;
    }

    public int getCibilScore() {
        return cibilScore;
    }

    public List<CollateralEntry> getCollaterals() {
        return collaterals;
    }

    public List<IncomeEntry> getIncomes() {
        return incomes;
    }

    public List<LoanEntry> getLoans() {
        return loans;
    }

}
