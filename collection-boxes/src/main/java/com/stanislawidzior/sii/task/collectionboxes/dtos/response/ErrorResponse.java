package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(String message, @JsonProperty("error_type") String errorType) {
}
