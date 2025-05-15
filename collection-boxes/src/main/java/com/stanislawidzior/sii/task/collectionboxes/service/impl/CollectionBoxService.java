package com.stanislawidzior.sii.task.collectionboxes.service.impl;

import com.stanislawidzior.sii.task.collectionboxes.client.CurrenciesConverterClient;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AssignCollectionBoxToEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.*;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.logic.*;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.notfound.ItemNotFoundException;
import com.stanislawidzior.sii.task.collectionboxes.mappers.CollectionBoxMapper;
import com.stanislawidzior.sii.task.collectionboxes.mappers.MonetaryValueMapper;
import com.stanislawidzior.sii.task.collectionboxes.model.CollectionBox;
import com.stanislawidzior.sii.task.collectionboxes.model.MonetaryValue;
import com.stanislawidzior.sii.task.collectionboxes.repositories.CollectionBoxRepository;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import com.stanislawidzior.sii.task.collectionboxes.service.ICollectionBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CollectionBoxService implements ICollectionBoxService {
    private final CollectionBoxRepository collectionBoxRepository;
    private final EventRepository eventRepository;
    private final CollectionBoxMapper collectionBoxMapper;
    private final MonetaryValueMapper monetaryValueMapper;
    private final CurrenciesConverterClient currenciesConverterClient;
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
           if (box.getEvent() != null) {
               box.getEvent().getCollectionBoxes().remove(box);
           }
           collectionBoxRepository.deleteById(collectionBoxId);
           return new DeleteCollectionBoxResponse(collectionBoxId, assignedEventId);
       }
       throw new ItemNotFoundException("Collection Box", collectionBoxId);
       }

    @Override
    public List<CollectionBoxDto> getAllCollectionBoxes() {
        return collectionBoxRepository.findAll().stream().map(box -> collectionBoxMapper.mapEntityToDto(box)).toList();
    }

    @Override
    @Transactional
    public AssignCollectionBoxToEventResponse assignCollectionBoxToEvent(Long id, AssignCollectionBoxToEventRequest assignCollectionBoxToEventRequest) {
        var boxOpt = collectionBoxRepository.findById(id);
        var eventOpt = eventRepository.findById(assignCollectionBoxToEventRequest.eventId());
        if(boxOpt.isPresent()) {
            var box = boxOpt.get();
            if(box.isAssigned()) {
                throw new AlreadyAssignedException();
            }
            if(!box.getMonetaryValues().isEmpty()){
                throw new AssigningOfNotEmptyBoxException();
            }
            if(!eventOpt.isPresent()) {
                throw new ItemNotFoundException("Event", assignCollectionBoxToEventRequest.eventId());
            }
            box.setEvent(eventOpt.get());
            box.setAssigned(true);
            collectionBoxRepository.save(box);
            return new AssignCollectionBoxToEventResponse(id, assignCollectionBoxToEventRequest.eventId());
        }
        throw new ItemNotFoundException("Collection Box", id);
    }

    @Override
    @Transactional
    public WithdrawalFromCollectionBoxResponse withdrawalFromCollectionBox(Long collectionBoxId) {
       var boxOpt =  collectionBoxRepository.findById(collectionBoxId);
       if(!boxOpt.isPresent()) {
           throw new ItemNotFoundException("Collection Box", collectionBoxId);
       }
       var box = boxOpt.get();
       if(!box.isAssigned()) {
           throw new CollectionBoxNotAssignedException();
       }
       var monetaryValues = box.getMonetaryValues();
       if(monetaryValues.isEmpty()){
           throw new BoxIsEmptyException();
       }
       BigDecimal amount = currenciesConverterClient.convertToPreferredCurrency(box.getEvent().getAccount().getCurrency(), monetaryValues);
       var currentBalance = box.getEvent().getAccount().getBalance();
       box.getEvent().getAccount().setBalance(amount.add(currentBalance));
       box.getMonetaryValues().clear();
       collectionBoxRepository.save(box);
       return new WithdrawalFromCollectionBoxResponse(box.getId(), box.getEvent().getId(), amount);
    }

    @Override
    @Transactional
    public DepositToCollectionBoxResponse depositToCollectionBox(Long id, DepositToCollectionBoxRequest depositToCollectionBoxRequest) {
        var boxOpt = collectionBoxRepository.findById(id);
        if(depositToCollectionBoxRequest.amount().compareTo(BigDecimal.valueOf(0)) < 1){
            throw new DepositAmountException();
        }
        if(!boxOpt.isPresent()) {
            throw new ItemNotFoundException("Collection Box", id);
        }
        var box = boxOpt.get();
        if(!box.isAssigned()) {
            throw new CollectionBoxNotAssignedException();
        }
        var monetaryValues = box.getMonetaryValues();
        updateMonetaryValue(monetaryValues, depositToCollectionBoxRequest, box);

        box.setMonetaryValues(monetaryValues);
        collectionBoxRepository.save(box);

        return new DepositToCollectionBoxResponse(box.getId(), depositToCollectionBoxRequest.amount(), depositToCollectionBoxRequest.currency());
    }
    private void updateMonetaryValue(List<MonetaryValue> monetaryValues, DepositToCollectionBoxRequest depositToCollectionBoxRequest, CollectionBox box){
        var requestEntity = monetaryValueMapper.getEntityFromDto(depositToCollectionBoxRequest);
        var currentMonetaryValueOpt = monetaryValues.stream().filter(m -> requestEntity.getCurrency().equals(m.getCurrency())).findFirst();
        if(currentMonetaryValueOpt.isEmpty()){
            requestEntity.setCollectionBox(box);
            monetaryValues.add(requestEntity);

        }
        else{
            var existingMonetaryValue = currentMonetaryValueOpt.get();
            currentMonetaryValueOpt.get().setAmount(existingMonetaryValue.getAmount().add(requestEntity.getAmount()));
        }
    }
}
