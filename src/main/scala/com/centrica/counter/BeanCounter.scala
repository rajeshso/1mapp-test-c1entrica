package com.centrica.counter
import akka.actor.{Actor, ActorRef}

/**
  * Created by rajesh on 18-Apr-17.
  */
sealed trait AddVegetable
case object AddBean extends AddVegetable
case object AddTomato extends AddVegetable
case object CountBeans
case object CountTomatoes

class BeanCounter(sender: ActorRef) extends Actor {
  var counter = 0
  def receive: PartialFunction[Any, Unit] = {
    case AddBean => counter += 1
    case AddTomato =>
    case CountBeans => sender ! counter
    case CountTomatoes => sender ! "Can't count, won't count tomatoes. i only count beans"
    case _ => sender ! "Invalid message"
  }
}
