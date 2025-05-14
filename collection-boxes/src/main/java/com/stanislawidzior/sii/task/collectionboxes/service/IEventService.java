package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.CreateEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.WithdrawalRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.CreateEventResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.EventReportResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ICrudResponse;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.WithdrawalFromCollectionBoxResponse;

public interface IEventService {
    CreateEventResponse createEvent(CreateEventRequest dto);
    WithdrawalFromCollectionBoxResponse withdrawalFromCollectionBox(WithdrawalRequest withdrawalRequest);
    EventReportResponse getReport();

}
