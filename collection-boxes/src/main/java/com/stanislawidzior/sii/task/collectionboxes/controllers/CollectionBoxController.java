package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AssignCollectionBoxToEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.*;
import com.stanislawidzior.sii.task.collectionboxes.service.ICollectionBoxService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boxes")
@RequiredArgsConstructor
public class CollectionBoxController {
    private final ICollectionBoxService collectionBoxService;


    @Operation(summary = "Create collection box",
            description = "Creates new empty collection box")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCollectionBoxResponse createCollectionBox() {
        return collectionBoxService.createCollectionBox();
    }
    @Operation(summary = "Delete collection box")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeleteCollectionBoxResponse deleteCollectionBox(@PathVariable Long id ) {
        return collectionBoxService.deleteCollectionBox(id);
    }
    @Operation(summary = "Get all boxes",
            description = "Returns list of collection boxes with their assignment status and whether they are empty")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CollectionBoxDto> getAllBoxes(){
        return collectionBoxService.getAllCollectionBoxes();
    }

    @Operation(summary = "Assign collection box to a event",
            description = "Assigns collection box to a event, id is for box id")
    @PatchMapping("/{id}/event")
    @ResponseStatus(HttpStatus.OK)
    public AssignCollectionBoxToEventResponse assignCollectionBoxToEvent(@PathVariable Long id, @RequestBody AssignCollectionBoxToEventRequest request) {
        return collectionBoxService.assignCollectionBoxToEvent(id, request);
    }
    @Operation(summary = "Deposit to collection box",
            description = "Deposits specified amount to collection box in chosen currency: USD, EUR or PLN")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepositToCollectionBoxResponse depositToCollectionBox(@PathVariable Long id, @RequestBody DepositToCollectionBoxRequest request) {
        return collectionBoxService.depositToCollectionBox(id, request);
    }
    @Operation(summary = "Empties collection box",
            description = "Empties collection box to assigned events account")
    @PatchMapping("/{id}/withdrawal")
    @ResponseStatus(HttpStatus.OK)
    public WithdrawalFromCollectionBoxResponse withdrawalAllFromCollectionBox(@PathVariable Long id ){
        return collectionBoxService.withdrawalFromCollectionBox(id);
        }


}
