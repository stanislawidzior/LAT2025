package com.stanislawidzior.sii.task.collectionboxes.mappers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CollectionBoxDto;
import com.stanislawidzior.sii.task.collectionboxes.model.CollectionBox;
import org.springframework.stereotype.Component;

@Component
public class CollectionBoxMapper {
    public CollectionBoxDto mapEntityToDto(CollectionBox collectionBox) {
        return new CollectionBoxDto(collectionBox.getMonetaryValues().isEmpty(), collectionBox.isAssigned());
    }
}
