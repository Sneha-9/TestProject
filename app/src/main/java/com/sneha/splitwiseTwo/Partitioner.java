package com.sneha.splitwiseTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioner {

    GroupInfo partition(int average, ExpenseRecord expenseRecord) {

        List<FriendExpenseRecord> friendExpenseRecordList = expenseRecord.getFriendExpenseRecordList();

        Map<Boolean, List<FriendExpenseRecord>> partionedResult = friendExpenseRecordList.stream().collect
                (Collectors.partitioningBy
                        (friendExpenseRecord -> average < friendExpenseRecord.getFriendTotalExpenses()));

        List<FriendExpenseRecord> receiverList = partionedResult.get(true);
        List<FriendExpenseRecord> senderList = partionedResult.get(false);

        List<FriendExpenseRatio> receiver = new ArrayList<>();

        for (FriendExpenseRecord f : receiverList) {
            receiver.add(new FriendExpenseRatio(f.getFriend(), new Amount(f.getFriendTotalExpenses() - average)));
        }

        List<FriendExpenseRatio> sender = new ArrayList<>();
        for (FriendExpenseRecord f : senderList) {
            sender.add(new FriendExpenseRatio(f.getFriend(), new Amount(average - f.getFriendTotalExpenses())));
        }


        return new GroupInfo(sender, receiver);
    }
}
