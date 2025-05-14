package com.stanislawidzior.sii.task.collectionboxes.service.impl;

import com.stanislawidzior.sii.task.collectionboxes.client.CurrenciesConverterClient;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.WithdrawalRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.EventReportResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.EventSummary;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.WithdrawalFromCollectionBoxResponse;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;
import com.stanislawidzior.sii.task.collectionboxes.mappers.AccountMapper;
import com.stanislawidzior.sii.task.collectionboxes.mappers.EventMapper;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import com.stanislawidzior.sii.task.collectionboxes.service.IEventService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    private final AccountMapper accountMapper;
    private final EventMapper eventMapper;
    private final CurrenciesConverterClient client;
    @Override
    public CreateEventResponse createEvent(CreateEventRequest dto) {
        var event = eventMapper.mapDtoToEntity(dto);
        var account = accountMapper.mapAccountDtoToEntity(dto.account());
        account.setEvent(event);
        event.setAccount(account);
        eventRepository.save(event);
        return new CreateEventResponse(event.getId());
    }

    @Override
    public WithdrawalFromCollectionBoxResponse withdrawalFromCollectionBox(WithdrawalRequest withdrawalRequest) {
       var eventOpt = eventRepository.findById(withdrawalRequest.eventId());
       if(!eventOpt.isPresent()){
           throw new EntityNotFoundException("Event of id: " + withdrawalRequest.eventId() + " was not found");
       }
       var event = eventOpt.get();
       var boxes = event.getCollectionBoxes();
       var boxOpt = boxes.stream().filter(box -> Objects.equals(box.getId(), withdrawalRequest.boxId())).findFirst();
       if(!boxOpt.isPresent()){
           throw new EntityNotFoundException("Box with id: " + withdrawalRequest.boxId() + " was not found");
       }
       var box = boxOpt.get();
       BigDecimal total = client.convertToPreferredCurrency(event.getAccount().getCurrency(),box.getMonetaryValues());
       var currentBalance = event.getAccount().getBalance();
       event.getAccount().setBalance(currentBalance.add(total));
       eventRepository.save(event);
       return new WithdrawalFromCollectionBoxResponse(box.getId(), event.getId(), event.getAccount().getBalance());
    }


    @Override
    public EventReportResponse getReport() {
        var events = eventRepository.findAll();
        var summariesList = events.stream().map(e ->
                new EventSummary(e.getTitle(),e.getAccount().getBalance(),e.getAccount().getCurrency().toString())).toList();
        return new EventReportResponse(summariesList);
    }
}
