package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record DepositToCollectionBoxResponse(@JsonProperty("collection_box_id") Long id, @JsonProperty("deposited_amount")BigDecimal depositedAmount, String currency) {
}
