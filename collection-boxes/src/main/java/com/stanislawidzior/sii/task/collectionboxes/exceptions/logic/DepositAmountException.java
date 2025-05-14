package com.stanislawidzior.sii.task.collectionboxes.exceptions;

public class DepositAmountException extends RuntimeException {
    public DepositAmountException() {
        super("Deposit Amount must be greater than 0");
    }
}
