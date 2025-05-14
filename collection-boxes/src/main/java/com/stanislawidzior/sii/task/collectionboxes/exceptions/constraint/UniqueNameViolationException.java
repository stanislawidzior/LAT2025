package com.stanislawidzior.sii.task.collectionboxes.exceptions.constraint;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.NotFoundException;

public class UniqueNameViolationException extends NotFoundException {
    public UniqueNameViolationException(String entityType, String entityName) {
        super("" + entityType + " with title: " + entityName + " already exists" );
    }

}
