package com.sneha.splitwiseTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class GroupInfo {
    private List<FriendExpenseRatio> sender;
    private List<FriendExpenseRatio> receiver;

}
