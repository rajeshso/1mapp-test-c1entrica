package com.centrica.counter
import akka.actor.{Actor, ActorRef}

/**
  * Created by rajesh on 18-Apr-17.
  */
sealed trait AddVegetable

case class AddBeans(n: Int) extends AddVegetable

case class AddTomatos(n: Int) extends AddVegetable
case object CountBeans
case object CountTomatoes

class BeanCounter(sender: ActorRef) extends Actor {
  var counter = 0
  def receive: PartialFunction[Any, Unit] = {
    case AddBeans(n: Int) => counter += n
    case AddTomatos(n: Int) => counter += n
    case CountBeans => sender ! counter
    case CountTomatoes => sender ! "Can't count, won't count tomatoes. i only count beans"
    case _ => sender ! "Invalid message"
  }

  override def postStop {
    println("BeanCounter: Thanks for using me to count beans. Bye")
  }
}
