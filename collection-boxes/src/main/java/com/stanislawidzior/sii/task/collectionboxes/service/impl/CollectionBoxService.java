package com.stanislawidzior.sii.task.collectionboxes.service.impl;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AssignCollectionBoxToEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.*;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;
import com.stanislawidzior.sii.task.collectionboxes.mappers.CollectionBoxMapper;
import com.stanislawidzior.sii.task.collectionboxes.mappers.MonetaryValueMapper;
import com.stanislawidzior.sii.task.collectionboxes.model.CollectionBox;
import com.stanislawidzior.sii.task.collectionboxes.repositories.CollectionBoxRepository;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import com.stanislawidzior.sii.task.collectionboxes.service.ICollectionBoxService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CollectionBoxService implements ICollectionBoxService {
    private final CollectionBoxRepository collectionBoxRepository;
    private final EventRepository eventRepository;
    private final CollectionBoxMapper collectionBoxMapper;
    private final MonetaryValueMapper monetaryValueMapper;
    @Override
    public CreateCollectionBoxResponse createCollectionBox() {
        var newBox = new CollectionBox();
        newBox.setAssigned(false);
        collectionBoxRepository.save(newBox);
        return new CreateCollectionBoxResponse(newBox.getId());
    }

    @Override
    public DeleteCollectionBoxResponse deleteCollectionBox(Long collectionBoxId) {
       var boxOpt = collectionBoxRepository.findById(collectionBoxId);
       if(boxOpt.isPresent()) {
           var box = boxOpt.get();
           Long assignedEventId = box.isAssigned() ? box.getEvent().getId() : null;
           collectionBoxRepository.deleteById(collectionBoxId);
           return new DeleteCollectionBoxResponse(collectionBoxId, assignedEventId);
       }
       throw new EntityNotFoundException("Item with id: " + collectionBoxId + " not found");
       }

    @Override
    public List<CollectionBoxDto> getAllCollectionBoxes() {
        return collectionBoxRepository.findAll().stream().map(box -> collectionBoxMapper.mapEntityToDto(box)).toList();
    }

    @Override
    public AssignCollectionBoxToEventResponse assignCollectionBoxToEvent(Long id, AssignCollectionBoxToEventRequest assignCollectionBoxToEventRequest) {
        var boxOpt = collectionBoxRepository.findById(id);
        var eventOpt = eventRepository.findById(assignCollectionBoxToEventRequest.eventId());
        if(boxOpt.isPresent()) {
            var box = boxOpt.get();
            if(box.isAssigned()) {
                throw new InvalidRequestException("Collection Box is already assigned");
            }
            if(!box.getMonetaryValues().isEmpty()){
                throw new InvalidRequestException("Collection Box must be empty");
            }
            if(!eventOpt.isPresent()) {
                throw new EntityNotFoundException("Event with id: " + assignCollectionBoxToEventRequest.eventId() + " not found");
            }
            box.setEvent(eventOpt.get());
            box.setAssigned(true);
            collectionBoxRepository.save(box);
            return new AssignCollectionBoxToEventResponse(id, assignCollectionBoxToEventRequest.eventId());
        }
        throw new EntityNotFoundException("Collection Box with id: " + id + " not found");
    }

    @Override
    public WithdrawalFromCollectionBoxResponse withdrawalFromCollectionBox(Long collectionBoxId) {
        return null;
    }

    @Override
    public DepositToCollectionBoxResponse depositToCollectionBox(Long id, DepositToCollectionBoxRequest depositToCollectionBoxRequest) {
        var boxOpt = collectionBoxRepository.findById(id);
        if(boxOpt.isPresent()) {
            var box = boxOpt.get();
            if(!box.isAssigned()) {
                throw new InvalidRequestException("Collection Box is not assigned to any event");
            }
            var monetaryValues = box.getMonetaryValues();
            monetaryValues.add(monetaryValueMapper.getEntityFromDto(depositToCollectionBoxRequest));
            box.setMonetaryValues(monetaryValues);
            collectionBoxRepository.save(box);
            return new DepositToCollectionBoxResponse(box.getId(), depositToCollectionBoxRequest.amount(), depositToCollectionBoxRequest.currency());
        }
        throw new EntityNotFoundException("Collection Box with id: " + id + " not found");
    }
}
