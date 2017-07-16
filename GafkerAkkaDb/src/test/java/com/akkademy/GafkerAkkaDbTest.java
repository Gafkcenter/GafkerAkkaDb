package com.akkademy;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.SetRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gafker on 2017/7/16.
 */
public class GafkerAkkaDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void isShouldPlaceKeyValueFromSetMessageIntoMap(){
        TestActorRef<GafkerAkkaDb> actorRef =  TestActorRef.create(system, Props.create(GafkerAkkaDb.class));
        actorRef.tell(new SetRequest("key","value"), TestActorRef.noSender());
        GafkerAkkaDb gafkerAkkaDb = actorRef.underlyingActor();
        assertEquals(gafkerAkkaDb.map.get("key"),"value");
    }
}
