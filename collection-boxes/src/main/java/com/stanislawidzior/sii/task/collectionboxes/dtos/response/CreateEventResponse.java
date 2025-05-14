package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEventResponse(@JsonProperty("event_id")Long id) implements ICrudResponse {
}
