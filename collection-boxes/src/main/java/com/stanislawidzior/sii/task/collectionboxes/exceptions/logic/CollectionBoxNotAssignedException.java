package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class CollectionBoxNotAssignedException extends InvalidRequestException {
    public CollectionBoxNotAssignedException() {
        super("Collection box not assigned");
    }
}
