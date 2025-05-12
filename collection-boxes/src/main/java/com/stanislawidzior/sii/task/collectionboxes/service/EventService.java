package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.EventDTO;
import com.stanislawidzior.sii.task.collectionboxes.mappers.AccountMapper;
import com.stanislawidzior.sii.task.collectionboxes.mappers.EventMapper;
import com.stanislawidzior.sii.task.collectionboxes.repositories.AccountRepository;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    private final AccountMapper accountMapper;
    private final EventMapper eventMapper;
    @Override
    public Long createEvent(EventDTO dto) {
        var event = eventMapper.mapEventDtoToEvent(dto);
        var account = accountMapper.mapAccountDtoToEntity(dto.account());
        account.setEvent(event);
        event.setAccount(account);
        eventRepository.save(event);
        return event.getId();
    }
}
