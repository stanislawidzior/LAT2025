package com.stanislawidzior.sii.task.collectionboxes.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WithdrawalRequest(@JsonProperty("collection_box_id") Long boxId) {
}
