package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class AlreadyAssignedException extends InvalidRequestException {
    public AlreadyAssignedException() {
        super("Collection box already assigned");
    }
}
