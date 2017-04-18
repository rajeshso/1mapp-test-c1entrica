package com.centrica.counter

import akka.actor.{ActorRef, Props}
import akka.testkit.TestActors
import scala.concurrent.duration._

/**
  * Created by rajes on 18-Apr-17.
  */
class BeanCounterTest extends UnitSpec {

  val testActorRef: ActorRef = system.actorOf(TestActors.echoActorProps)

  override def afterAll {
    shutdown()
  }

  "A TestActor" should {
    "Respond with the test message it receives" in {
      within(500 millis) {
        testActorRef ! "test"
        expectMsg("test")
      }
    }
  }
}
