package com.stanislawidzior.sii.task.collectionboxes.mappers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.DepositToCollectionBoxRequest;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.CurrencyDeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.model.MonetaryValue;
import com.stanislawidzior.sii.task.collectionboxes.model.enums.Currencies;
import org.springframework.stereotype.Component;

@Component
public class MonetaryValueMapper {
public MonetaryValue getEntityFromDto(DepositToCollectionBoxRequest dto){
    MonetaryValue monetaryValue = new MonetaryValue();
    monetaryValue.setAmount(dto.amount());
    try {
        monetaryValue.setCurrency(Currencies.valueOf(dto.currency().toUpperCase()));
    }catch (Exception e){
        throw new CurrencyDeserializationException("Invalid currency: " + dto.currency());
    }
    return monetaryValue;
}
}
