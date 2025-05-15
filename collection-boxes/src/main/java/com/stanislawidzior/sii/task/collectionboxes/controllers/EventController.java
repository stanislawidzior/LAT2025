package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.WithdrawalRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.EventReportResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.WithdrawalFromCollectionBoxResponse;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;
    @Operation(summary = "Create a new event",
            description = "Creates a new fundraising event with a linked account, available " +
                    "currencies: USD, PLN, EUR")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest createEventDTO) {
        return eventService.createEvent(createEventDTO);
}
    @Operation(summary = "Get report",
            description = "Returns a report with all events and their accounts balance")
    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    public EventReportResponse getReport(){
        return eventService.getReport();
    }
    @Operation(summary = "Empty collection box",
            description = "Withdrawals all funds from collection box to linked events account")
    @PatchMapping("/{id}/boxes")
    @ResponseStatus(HttpStatus.OK)
    public WithdrawalFromCollectionBoxResponse withdrawalFromBox(@PathVariable Long id, @RequestBody WithdrawalRequest request){
        return eventService.withdrawalFromCollectionBox(id, request);
    }

}
