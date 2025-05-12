package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.EventDTO;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.CurrencyDeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;
    @ExceptionHandler(CurrencyDeserializationException.class)
    public ResponseEntity<String> handleInvalidCurrency(CurrencyDeserializationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @PostMapping("/")
    public ResponseEntity createEvent(@RequestBody EventDTO createEventDTO) throws CurrencyDeserializationException {
    var id = eventService.createEvent(createEventDTO);
    return ResponseEntity.ok().body("Created event with id: " + id);
}
}
