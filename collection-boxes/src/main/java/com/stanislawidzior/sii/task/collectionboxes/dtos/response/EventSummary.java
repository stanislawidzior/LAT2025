package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import java.math.BigDecimal;

public record EventSummary(String name, BigDecimal amount, String currency) {
}
