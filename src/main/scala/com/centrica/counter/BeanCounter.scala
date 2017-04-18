package com.centrica.counter
import akka.actor.{Actor, ActorRef}

/**
  * Created by rajes on 18-Apr-17.
  */
sealed trait AddVegetable
case object AddBean extends AddVegetable
case object CountBeans

class BeanCounter(sender: ActorRef) extends Actor {
  var counter = 0
  def receive: PartialFunction[Any, Unit] = {
    case AddBean => counter += 1
    case CountBeans => sender ! counter
    case _ => sender ! "Invalid Message"
  }
}
