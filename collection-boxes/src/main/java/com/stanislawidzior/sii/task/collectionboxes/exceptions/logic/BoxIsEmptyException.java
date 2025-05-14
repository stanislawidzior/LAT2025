package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class BoxIsEmptyException extends InvalidRequestException {
    public BoxIsEmptyException() {
        super("Collection Box is empty");
    }
}
