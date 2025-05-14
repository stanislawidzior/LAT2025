package com.stanislawidzior.sii.task.collectionboxes.dtos.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountDTO(@JsonProperty("preferred_currency")String preferredCurrency) {

}
