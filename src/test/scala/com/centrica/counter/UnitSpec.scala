package com.centrica.counter
import akka.actor.ActorSystem
import akka.testkit.{DefaultTimeout, ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
/**
  * Created by rajes on 18-Apr-17.
  */
abstract class UnitSpec extends TestKit(ActorSystem(
  "UnitSpec",
  ConfigFactory.parseString(UnitSpec.config)))
  with DefaultTimeout with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll

object UnitSpec {
  // test specific configuration
  val config =
    """
    akka {
      loglevel = "WARNING"
    }
    """
}
