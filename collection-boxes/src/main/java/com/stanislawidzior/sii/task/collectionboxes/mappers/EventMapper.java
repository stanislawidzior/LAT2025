package com.stanislawidzior.sii.task.collectionboxes.mappers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event mapEventDtoToEvent(CreateEventRequest eventDto){
        var event = new Event();
        event.setTitle(eventDto.title());
        return event;
    }
}
