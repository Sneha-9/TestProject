package com.sneha.splitwiseTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Partitioner partitioner = new Partitioner();

        ExpenseSplitCalculator expenseSplitCalculator = new ExpenseSplitCalculator();

        Splitwise splitwise = new Splitwise(partitioner, expenseSplitCalculator);

        List<FriendExpenseRecord> friendExpenseRecordList = new ArrayList<>();

        FriendExpenseRecord friendExpenseRecordOne = new FriendExpenseRecord(new Friend(),
                Arrays.asList(new Amount(100), new Amount(50), new Amount(300), new Amount(15)));
        FriendExpenseRecord friendExpenseRecordTwo = new FriendExpenseRecord(new Friend(),
                Arrays.asList(new Amount(50), new Amount(15)));
        FriendExpenseRecord friendExpenseRecordThree = new FriendExpenseRecord(new Friend(),
                Arrays.asList(new Amount(400), new Amount(20)));
        FriendExpenseRecord friendExpenseRecordFour = new FriendExpenseRecord(new Friend(),
                Arrays.asList(new Amount(100), new Amount(30)));


        friendExpenseRecordList.add(friendExpenseRecordOne);
        friendExpenseRecordList.add(friendExpenseRecordTwo);
        friendExpenseRecordList.add(friendExpenseRecordThree);
        friendExpenseRecordList.add(friendExpenseRecordFour);

        ExpenseRecord expenseRecord = new ExpenseRecord(friendExpenseRecordList);

        List<ExpenseSplitRecord> expenseSplitRecords = splitwise.calculate(expenseRecord);

        for (ExpenseSplitRecord e : expenseSplitRecords) {
            System.out.println("Payer = " + e.getPayer().getId() + " Payee = " + e.getPayee().getId() + " Amount  = " + e.getAmount().getValue());
        }
    }
}
