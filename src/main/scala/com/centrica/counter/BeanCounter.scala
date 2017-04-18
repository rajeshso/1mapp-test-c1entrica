package com.centrica.counter
import akka.actor.{Actor, ActorRef}

/**
  * Created by rajes on 18-Apr-17.
  */
class BeanCounter(sender: ActorRef) extends Actor {
  var counter = 0
  def receive: PartialFunction[Any, Unit] = {
    case _ => sender ! "test"
  }
}
