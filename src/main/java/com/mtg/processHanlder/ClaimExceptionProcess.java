package com.mtg.processHanlder;

import com.mtg.exception.ResourceNotFoundException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ClaimExceptionProcess implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        throw new ResourceNotFoundException("Exception Occured");
    }
}
