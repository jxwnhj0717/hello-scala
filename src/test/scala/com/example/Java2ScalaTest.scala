package com.example

import org.junit.jupiter.api.{Assertions, Test}

/**
 * Scala实用指南第3章：从Java到Scala
 */
class Java2ScalaTest {

  /**
   * 元组和多重赋值
   */
  @Test
  def tuple: Unit = {
    var (firstName, lastName, emailAddress) = getPersonInfo
    println(s"person info: $firstName, $lastName, $emailAddress")

    var info = getPersonInfo
    println(s"person info: ${info._1}, ${info._2}, ${info._3}")
  }

  private def getPersonInfo = {
    ("firstName", "lastName", "emailAddress")
  }

  /**
   * 灵活的参数和参数值
   */
  @Test
  def variableLengthParameter: Unit = {
    printInts("ps1", 1, 2, 3)
    // :_* 可以展开List，匹配变长参数
    val list = List(1, 2, 3, 4, 5)
    printInts("ps2", list:_*)
  }

  private def printInts(name : String, ps : Int*): Unit = {
    println(s"$name: $ps")
  }

  @Test
  def implicitParameter: Unit = {
    implicit var wifi = "home"
    connectToNetwork("Jane")
    wifi = "cafe"
    connectToNetwork("Frank")
  }

  private def connectToNetwork(user : String)(implicit wifi : String): Unit = {
    println(s"user:$user connect to WIFI $wifi")
  }

  @Test
  def operator: Unit = {
    Assertions.assertEquals(1 + 1, 1.+(1))
  }

}
