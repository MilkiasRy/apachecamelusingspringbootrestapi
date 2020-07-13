package com.mtg.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("ClaimResourceExceptionHandlerService")
public class ClaimResourceExceptionHanlderService  implements ClaimExceptionalHandleService{
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void handleResourceException(Exchange e, Exception causedBy) {
        logger.info(

                "threhold has been reached\n"+
                "Exchange route id :"+e.getFromRouteId() +
                        "\ncaused:"+causedBy.getMessage()+
                        "\n"



        );
    }
}
