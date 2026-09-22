package com.sneha.splitwiseTwo;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExpenseSplitRecord {
    private Friend payer;
    private Friend payee;
    private Amount amount;
}
