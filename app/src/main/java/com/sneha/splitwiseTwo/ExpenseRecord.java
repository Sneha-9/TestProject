package com.sneha.splitwiseTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExpenseRecord {
    private List<FriendExpenseRecord> friendExpenseRecordList;

    void add(FriendExpenseRecord friendExpenseRecord){
        friendExpenseRecordList.add(friendExpenseRecord);
    }

    int getTotalExpenses(){
        int result  = friendExpenseRecordList.stream().mapToInt(FriendExpenseRecord::getFriendTotalExpenses).sum();
        return result;
    }

    List<FriendExpenseRecord> getFriendsExpensesList(){
        return friendExpenseRecordList;
    }

    int getFriendListSize(){
        return friendExpenseRecordList.size();
    }

}
