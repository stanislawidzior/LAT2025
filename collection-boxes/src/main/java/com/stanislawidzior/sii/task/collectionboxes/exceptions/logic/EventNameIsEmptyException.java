package com.stanislawidzior.sii.task.collectionboxes.exceptions.logic;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;

public class EventNameIsEmptyException extends InvalidRequestException {
    public EventNameIsEmptyException() {
        super("Title is empty");
    }
}
