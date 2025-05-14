package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ErrorResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ICrudResponse;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.CurrencyDeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ICrudResponse createEvent(@RequestBody CreateEventRequest createEventDTO) throws CurrencyDeserializationException {
        return eventService.createEvent(createEventDTO);
}

}
