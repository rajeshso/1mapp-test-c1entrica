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
  "My Bean Counter" should {
    "return 0 when there are no beans added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      messages.toString should equal ("0")
    }
  }
  "My Bean Counter" should {
    "return one as a Count when one bean is added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      messages.toString should equal ("1")
    }
  }
  "My Bean Counter" should {
    "return one as a Count when one bean is added again" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      messages.toString should equal ("1")
    }
  }
  "My Bean Counter" should {
    "return five as a Count when five beans are added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef !  AddBean
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      messages.toString should equal ("5")
    }
  }
}
