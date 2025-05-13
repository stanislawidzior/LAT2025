package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ICrudResponse;
import com.stanislawidzior.sii.task.collectionboxes.mappers.AccountMapper;
import com.stanislawidzior.sii.task.collectionboxes.mappers.EventMapper;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    private final AccountMapper accountMapper;
    private final EventMapper eventMapper;
    @Override
    public CreateEventResponse createEvent(CreateEventRequest dto) {
        var event = eventMapper.mapEventDtoToEvent(dto);
        var account = accountMapper.mapAccountDtoToEntity(dto.account());
        account.setEvent(event);
        event.setAccount(account);
        eventRepository.save(event);
        return new CreateEventResponse(event.getId());
    }
}
