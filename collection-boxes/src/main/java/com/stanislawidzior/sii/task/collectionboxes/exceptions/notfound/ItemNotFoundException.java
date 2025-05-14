package com.stanislawidzior.sii.task.collectionboxes.exceptions.notfound;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.NotFoundException;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.PersistenceException;

public class ItemNotFoundException extends NotFoundException {
    public ItemNotFoundException(String entityType, Long id ) {
        super(entityType + " with id: " + id + " not found");
    }
}
