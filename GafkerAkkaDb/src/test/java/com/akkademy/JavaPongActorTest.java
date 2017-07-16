package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;
import scala.PartialFunction;

import static org.junit.Assert.*;

/**
 * Created by gafker on 2017/7/16.
 */
public class JavaPongActorTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void testReceive() throws Exception {
        TestActorRef<JavaPongActor> actorRef =TestActorRef.create(system, Props.create(JavaPongActor.class));
        actorRef.tell("Ping", ActorRef.noSender());
        JavaPongActor javaPongActor = actorRef.underlyingActor();
        assertEquals(javaPongActor.toString(),"Pong");
    }
}