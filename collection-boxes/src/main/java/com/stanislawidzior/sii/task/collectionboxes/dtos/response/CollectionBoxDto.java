package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CollectionBoxDto(@JsonProperty("collection_box_id")Long id, @JsonProperty("is_empty")boolean isEmpty, @JsonProperty("is_assigned")boolean isAssigned) {
}
