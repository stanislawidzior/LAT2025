package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class DepositAmountException extends InvalidRequestException {
    public DepositAmountException() {
        super("Deposit Amount must be greater than 0");
    }
}
