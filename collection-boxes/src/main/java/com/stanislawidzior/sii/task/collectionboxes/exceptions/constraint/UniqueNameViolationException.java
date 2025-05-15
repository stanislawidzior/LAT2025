package com.stanislawidzior.sii.task.collectionboxes.exceptions.constraint;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.ConstraintException;

public class UniqueNameViolationException extends ConstraintException {
    public UniqueNameViolationException(String entityType, String entityName) {
        super("" + entityType + " with title: " + entityName + " already exists" );
    }

}
