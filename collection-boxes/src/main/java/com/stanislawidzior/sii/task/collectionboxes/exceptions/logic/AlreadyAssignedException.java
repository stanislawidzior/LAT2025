package com.stanislawidzior.sii.task.collectionboxes.exceptions;

public class AlreadyAssignedException extends ValidationException {
    public AlreadyAssignedException() {
        super("Collection box already assigned");
    }
}
