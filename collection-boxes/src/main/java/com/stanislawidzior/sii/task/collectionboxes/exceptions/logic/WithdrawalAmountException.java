package com.stanislawidzior.sii.task.collectionboxes.exceptions;

import java.math.BigDecimal;

public class WithdrawalAmountException extends RuntimeException{
    public WithdrawalAmountException(BigDecimal amount){
        super("Ivalid withdrawal amount: " + amount);
    }
}
