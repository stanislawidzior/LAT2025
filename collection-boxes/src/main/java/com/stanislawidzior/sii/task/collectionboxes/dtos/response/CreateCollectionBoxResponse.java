package com.stanislawidzior.sii.task.collectionboxes.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateCollectionBoxResponse(@JsonProperty("created_box_id")Long id) implements ICrudResponse {

}
