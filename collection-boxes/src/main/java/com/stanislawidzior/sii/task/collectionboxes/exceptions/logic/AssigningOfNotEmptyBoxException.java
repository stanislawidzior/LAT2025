package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class AssigningOfNotEmptyBoxException extends InvalidRequestException {
    public AssigningOfNotEmptyBoxException() {
        super("Collection Box must be empty to assign");
    }
}
