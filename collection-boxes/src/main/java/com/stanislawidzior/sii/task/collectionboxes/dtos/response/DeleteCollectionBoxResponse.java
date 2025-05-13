package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteCollectionBoxResponse(@JsonProperty("unregistered_box_id") Long id, @JsonProperty("unlinked_event_id")Long eventId) implements ICrudResponse {
}
