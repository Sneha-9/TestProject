package com.sneha.splitwiseTwo;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Splitwise {
    private Partitioner partitioner;
    private ExpenseSplitCalculator expenseSplitCalculator;

    List<ExpenseSplitRecord> calculate(ExpenseRecord expenseRecord) {
        int totalExpenses = expenseRecord.getTotalExpenses();

        int average = totalExpenses / expenseRecord.getFriendListSize();

        GroupInfo groupInfo = partitioner.partition(average, expenseRecord);

        return expenseSplitCalculator.calculate(groupInfo);
    }
}
