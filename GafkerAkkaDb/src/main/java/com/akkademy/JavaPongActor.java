package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * Created by gafker on 2017/7/16.
 */
public class JavaPongActor extends AbstractActor {
    @Override
    public PartialFunction receive() {
        return ReceiveBuilder.matchEquals("Ping", s -> sender()
                .tell("Pong", ActorRef.noSender())).matchAny(x -> sender()
                .tell(new Status.Failure(new Exception("unknown message")), self()))
                .build();
    }
    public static Props props(String response){
        //this.class=JavaPongActor.class
        return  Props.create(JavaPongActor.class,response);
    }
}
