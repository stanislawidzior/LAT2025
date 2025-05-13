package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ICrudResponse;

public interface IEventService {
    CreateEventResponse createEvent(CreateEventRequest dto);

}
