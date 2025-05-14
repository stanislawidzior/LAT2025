package com.stanislawidzior.sii.task.collectionboxes.exceptions.persitance;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.PersistenceException;

public class UniqueNameViolationException extends PersistenceException {
    public UniqueNameViolationException(String entityType, String entityName) {
        super("" + entityType + " with title: " + entityName + " already exists" );
    }

}
