package com.stanislawidzior.sii.task.collectionboxes.exceptions;

public class CurrencyDeserializationException extends ValidationException {
    public CurrencyDeserializationException(String currency) {
        super("Invalid currency: " + currency);
    }
}
