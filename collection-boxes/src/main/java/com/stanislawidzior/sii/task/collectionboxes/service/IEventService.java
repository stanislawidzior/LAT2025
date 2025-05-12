package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.EventDTO;

public interface IEventService {
    Long createEvent(EventDTO dto);

}
