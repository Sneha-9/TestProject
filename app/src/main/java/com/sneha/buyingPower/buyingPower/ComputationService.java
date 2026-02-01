package com.sneha.buyingPower.buyingPower;

import com.sneha.buyingPower.collateral.CollateralEntry;
import com.sneha.buyingPower.income.IncomeEntry;
import com.sneha.buyingPower.loan.LoanEntry;

public class ComputationService {


    public int computeData(ComputationData computationData) {
        int incomes = computationData.getIncomes()
                .stream()
                .map(IncomeEntry::getAmount)
                .reduce(0, Integer::sum);

        int loans = computationData.getLoans()
                .stream()
                .map(LoanEntry::getAmount)
                .reduce(0, Integer::sum);

        int collaterals = computationData.getCollaterals()
                .stream()
                .map(CollateralEntry::getAmount)
                .reduce(0, Integer::sum);

        int cibilScore = computationData.getCibilScore();
        int result = ((incomes * 6) - (loans * 6) + (collaterals / 2)) * (cibilScore / 100);

        return result;
    }
}
