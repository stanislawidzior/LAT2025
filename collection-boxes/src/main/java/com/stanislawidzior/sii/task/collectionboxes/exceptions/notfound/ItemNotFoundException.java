package com.stanislawidzior.sii.task.collectionboxes.exceptions.persitance;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.PersistenceException;

public class ItemNotFoundException extends PersistenceException {
    public ItemNotFoundException(String entityType, Long id ) {
        super(entityType + " with id: " + id + " not found");
    }
}
