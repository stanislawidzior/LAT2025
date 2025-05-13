package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.CurrencyDeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;
    @ExceptionHandler(CurrencyDeserializationException.class)
    public ResponseEntity<String> handleInvalidCurrency(CurrencyDeserializationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @PostMapping("/")
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest createEventDTO) throws CurrencyDeserializationException {
    var id = eventService.createEvent(createEventDTO);
    return ResponseEntity.ok().body(new CreateEventResponse(id));
}

}
