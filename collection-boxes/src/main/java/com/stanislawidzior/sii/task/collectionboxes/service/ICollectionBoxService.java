package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AssignCollectionBoxToEventRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.dtos.response.*;

import java.util.List;

public interface ICollectionBoxService {
CreateCollectionBoxResponse createCollectionBox();
DeleteCollectionBoxResponse deleteCollectionBox(Long collectionBoxId);
List<CollectionBoxDto> getAllCollectionBoxes();
AssignCollectionBoxToEventResponse assignCollectionBoxToEvent(Long id, AssignCollectionBoxToEventRequest assignCollectionBoxToEventRequest);
WithdrawalFromCollectionBoxResponse withdrawalFromCollectionBox(Long collectionBoxId);
DepositToCollectionBoxResponse depositToCollectionBox(Long id, DepositToCollectionBoxRequest depositToCollectionBoxRequest);

}
