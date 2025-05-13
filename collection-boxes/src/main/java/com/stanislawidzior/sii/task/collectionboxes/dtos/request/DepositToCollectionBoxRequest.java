package com.stanislawidzior.sii.task.collectionboxes.dtos.request;


import java.math.BigDecimal;

public record DepositToCollectionBoxRequest(String currency, BigDecimal amount) {

}
