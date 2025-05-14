package com.stanislawidzior.sii.task.collectionboxes.exceptions;

public class AssigningOfNotEmptyBoxException extends ValidationException {
    public AssigningOfNotEmptyBoxException() {
        super("Collection Box must be empty to assign");
    }
}
