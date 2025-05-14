package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.WithdrawalRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.EventReportResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.WithdrawalFromCollectionBoxResponse;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest createEventDTO) {
        return eventService.createEvent(createEventDTO);
}
    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public EventReportResponse getReport(){
        return eventService.getReport();
    }
    @PatchMapping("/{id}/boxes")
    @ResponseStatus(HttpStatus.OK)
    public WithdrawalFromCollectionBoxResponse withdrawalFromBox(@RequestBody WithdrawalRequest request){
        return eventService.withdrawalFromCollectionBox(request);
    }

}
