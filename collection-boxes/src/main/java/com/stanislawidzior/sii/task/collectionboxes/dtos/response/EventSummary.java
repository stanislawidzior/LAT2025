package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record EventSummary(@JsonProperty("event_id")Long id, String name, BigDecimal amount, String currency) {
}
