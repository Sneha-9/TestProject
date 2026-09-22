package com.sneha.splitwiseTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FriendExpenseRecord {
    private Friend friend;
    private List<Amount> expense;

    void add(Amount amount){
        expense.add(amount);
    }

    int getFriendTotalExpenses(){
      int result = expense.stream().mapToInt(Amount::getValue).sum();
      return result;
    }


}
