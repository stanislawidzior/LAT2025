package com.stanislawidzior.sii.task.collectionboxes.client;

import com.stanislawidzior.sii.task.collectionboxes.exceptions.logic.WithdrawalAmountException;
import com.stanislawidzior.sii.task.collectionboxes.model.MonetaryValue;
import com.stanislawidzior.sii.task.collectionboxes.model.enums.Currencies;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CurrenciesConverterClient {
    BigDecimal plnToUsd = BigDecimal.valueOf(0.26);
    BigDecimal eurToUsd = BigDecimal.valueOf(1.12);
    BigDecimal usdToEur = BigDecimal.valueOf(0.89);
    BigDecimal usdToPln = BigDecimal.valueOf(3.78);
    private BigDecimal convertToPreferredCurrency(Currencies currentCurrency, Currencies preferredCurrency, BigDecimal amount){
        switch(currentCurrency){
            case EUR:
                amount = amount.multiply(eurToUsd);
                break;
                case PLN:
                amount = amount.multiply(plnToUsd);
                break;
            default:
                break;
        }
        switch(preferredCurrency){
            case EUR:
                return amount.multiply(usdToEur);
            case PLN:
                return amount.multiply(usdToPln);
            default:
                return amount;
        }

    }
    public BigDecimal convertToPreferredCurrency(Currencies preferredCurrency, List<MonetaryValue> monetaryValues){
        BigDecimal total =  monetaryValues.stream()
                .map(mv -> {
                    if (mv.getCurrency()!=preferredCurrency) {
                        return convertToPreferredCurrency(mv.getCurrency(), preferredCurrency, mv.getAmount());
                    } else {
                        return mv.getAmount();
                    }
                }).reduce(BigDecimal.valueOf(0), (acc,val)-> acc.add(val));
        if(total.compareTo(BigDecimal.valueOf(0)) < 1){
            throw new WithdrawalAmountException(total);
        }
        return total;
    }
}
