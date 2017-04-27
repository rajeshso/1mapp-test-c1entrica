package com.centrica.counter

import akka.actor.{ActorRef, Props}
import akka.testkit.TestActors
import scala.concurrent.duration._

/**
  * Created by rajesh on 18-Apr-17.
  */
class BeanCounterTest extends UnitSpec {

  override def afterAll {
    shutdown()
  }

  "A TestActor" should {
    "Respond with the test message it receives" in {
      val testActorRef: ActorRef = system.actorOf(TestActors.echoActorProps)
      within(500 millis) {
        testActorRef ! "test"
        expectMsg("test")
      }
      system.stop(testActorRef)
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
      system.stop(beanCounterActorNewRef)
      messages.toString should equal ("0")
    }
  }
  "My Bean Counter" should {
    "return one as a Count when one bean is added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! AddBeans(1)
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      system.stop(beanCounterActorNewRef)
      messages.toString should equal ("1")
    }
  }
  "My Bean Counter" should {
    "return one as a Count when one bean is added again" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! AddBeans(1)
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      system.stop(beanCounterActorNewRef)
      messages.toString should equal ("1")
    }
  }
  "My Bean Counter" should {
    "return five as a Count when five beans are added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! AddBeans(5)
        beanCounterActorNewRef ! CountBeans
        messages = receiveOne(100 millis)
      }
      system.stop(beanCounterActorNewRef)
      messages.toString should equal ("5")
    }
  }
  "My Bean Counter" should {
    "return a message when a tomato is added" in {
      var messages : AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! AddTomatos(1)
        beanCounterActorNewRef ! CountTomatoes
        messages = receiveOne(100 millis)
      }
      system.stop(beanCounterActorNewRef)
      messages.toString should equal ("Can't count, won't count tomatoes. i only count beans")
    }
  }
  "My Bean Counter" should {
    "return an Invalid message for an incorrect input" in {
      var messages: AnyRef = ""
      val beanCounterActorNewRef = system.actorOf(Props(classOf[BeanCounter], testActor))
      within(100 millis) {
        beanCounterActorNewRef ! Int
        messages = receiveOne(100 millis)
      }
      system.stop(beanCounterActorNewRef)
      messages.toString should equal("Invalid message")
    }
  }
}
