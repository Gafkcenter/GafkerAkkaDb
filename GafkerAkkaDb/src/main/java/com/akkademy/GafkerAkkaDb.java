package com.akkademy;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

public class GafkerAkkaDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    public GafkerAkkaDb() {
        receive(ReceiveBuilder.match(SetRequest.class, message -> {
            log.info("Received Set request: {}", message);
            map.put("key","value");
        }).matchAny(o -> log.info("Recived unknown message: {}", o)).build());
    }
}