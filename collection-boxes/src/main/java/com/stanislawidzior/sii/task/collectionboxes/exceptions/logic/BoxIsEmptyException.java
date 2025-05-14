package com.stanislawidzior.sii.task.collectionboxes.exceptions;

public class BoxIsEmptyException extends ValidationException {
    public BoxIsEmptyException() {
        super("Collection Box is empty");
    }
}
