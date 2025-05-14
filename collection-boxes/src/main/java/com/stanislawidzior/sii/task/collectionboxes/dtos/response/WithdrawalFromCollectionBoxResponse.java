package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record WithdrawalFromCollectionBoxResponse(@JsonProperty("collection_box_id")Long boxId, @JsonProperty("event_id")Long eventId,@JsonProperty("withdrawal_amount") BigDecimal amount) {
}
