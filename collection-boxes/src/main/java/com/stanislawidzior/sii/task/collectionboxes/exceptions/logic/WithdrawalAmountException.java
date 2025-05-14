package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

import java.math.BigDecimal;

public class WithdrawalAmountException extends InvalidRequestException {
    public WithdrawalAmountException(BigDecimal amount){
        super("Ivalid withdrawal amount: " + amount);
    }
}
