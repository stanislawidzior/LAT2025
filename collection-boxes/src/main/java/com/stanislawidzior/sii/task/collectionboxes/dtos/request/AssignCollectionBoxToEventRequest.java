package com.stanislawidzior.sii.task.collectionboxes.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AssignCollectionBoxToEventRequest(@JsonProperty("event_id")Long eventId) {
}
