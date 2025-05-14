package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AssignCollectionBoxToEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.*;
import com.stanislawidzior.sii.task.collectionboxes.service.ICollectionBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boxes")
@RequiredArgsConstructor
public class CollectionBoxController {
    private final ICollectionBoxService collectionBoxService;



    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCollectionBoxResponse createCollectionBox() {
        return collectionBoxService.createCollectionBox();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeleteCollectionBoxResponse deleteCollectionBox(@PathVariable Long id ) {
        return collectionBoxService.deleteCollectionBox(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CollectionBoxDto> getAllBoxes(){
        return collectionBoxService.getAllCollectionBoxes();
    }
    @PatchMapping("/{id}/event")
    @ResponseStatus(HttpStatus.OK)
    public AssignCollectionBoxToEventResponse assignCollectionBoxToEvent(@PathVariable Long id, @RequestBody AssignCollectionBoxToEventRequest request) {
        return collectionBoxService.assignCollectionBoxToEvent(id, request);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepositToCollectionBoxResponse depositToCollectionBox(@PathVariable Long id, @RequestBody DepositToCollectionBoxRequest request) {
        return collectionBoxService.depositToCollectionBox(id, request);
    }
    @PatchMapping("/{id}/withdrawal")
    @ResponseStatus(HttpStatus.OK)
    public WithdrawalFromCollectionBoxResponse withdrawalAllFromCollectionBox(@PathVariable Long id ){
        return collectionBoxService.withdrawalFromCollectionBox(id);
        }


}
