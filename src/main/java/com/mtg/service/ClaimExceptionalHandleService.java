package com.mtg.service;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangeException;
import org.springframework.stereotype.Component;

@Component
public interface ClaimExceptionalHandleService {

    void handleResourceException(Exchange e, @ExchangeException Exception causedBy);


}
