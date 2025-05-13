package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AssignCollectionBoxToEventResponse(@JsonProperty("collection_box_id")Long boxId, @JsonProperty("assigned_event_id") Long eventId) {
}
