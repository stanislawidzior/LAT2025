package com.stanislawidzior.sii.task.collectionboxes.mappers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.request.AccountDTO;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.deserialization.CurrencyDeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.model.Account;
import com.stanislawidzior.sii.task.collectionboxes.model.enums.Currencies;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountMapper {
    public Account mapAccountDtoToEntity(AccountDTO accountDto)  {
        var account = new Account();
        account.setBalance(BigDecimal.valueOf(0));
        try {
            account.setCurrency(Currencies.valueOf(accountDto.preferredCurrency().toUpperCase()));
        }catch (Exception e){
            throw new CurrencyDeserializationException("Invalid currency: " + accountDto.preferredCurrency());
        }
        return account;
    }
}
