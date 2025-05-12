package com.stanislawidzior.sii.task.collectionboxes.mappers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.EventDTO;
import com.stanislawidzior.sii.task.collectionboxes.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event mapEventDtoToEvent(EventDTO eventDto){
        var event = new Event();
        event.setTitle(eventDto.title());
        return event;
    }
}
