package com.example

import org.junit.jupiter.api.Test

/**
 * Scala实用指南第9章：模式匹配和正则表达式
 */
class PatternTest {

  trait Message

  case class Register(id : String) extends Message
  case class Login(id : String) extends Message
  case class Logout(id : String) extends Message

  @Test
  def caseMatch: Unit = {
    handleMessage(new Register("hj"))
    handleMessage(new Login("hj"))
    handleMessage(new Logout("hj"))
    handleMessage(new Register("admin"))
    handleMessage(new Login("admin"))
    handleMessage(new Logout("admin"))
  }

  def handleMessage(message : Message): Unit = {
    message match {
      case Register(msg) => println(s"register id:$msg")
      case Login("admin") => println(s"admin login")
      case Login(msg) => println(s"login id:$msg")
      case Logout("admin") => println(s"admin logout")
      case Logout(msg) => println(s"Logout id:$msg")
    }
  }

  @Test
  def regexpMatch: Unit = {
    handleMessageByRegexp("hj hello")
    handleMessageByRegexp("admin hello")
  }

  def handleMessageByRegexp(input : String): Unit = {
    val Pattern = """(\w+) (\w+)""".r
    input match {
      case Pattern("hj", msg) => println(s"hj: $msg")
      case Pattern(name, msg) => println(s"name:$name, msg:$msg")
    }
  }

}
