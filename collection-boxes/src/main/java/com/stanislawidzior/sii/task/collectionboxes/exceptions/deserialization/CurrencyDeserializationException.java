package com.stanislawidzior.sii.task.collectionboxes.exceptions.deserialization;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.DeserializationException;

public class CurrencyDeserializationException extends DeserializationException {
    public CurrencyDeserializationException(String currency) {
        super("Invalid currency: " + currency);
    }
}
