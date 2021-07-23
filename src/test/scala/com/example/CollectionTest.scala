package com.example

import org.junit.jupiter.api.Test

/**
 * Scala实用指南第8章：集合
 */
class CollectionTest {

  @Test
  def list: Unit = {
    var list = List(1, 2, 3)
    // 将0前插到list
    var list2 = 0 :: list
    // 将List(-1, -2, -3)前插到list
    var list3 = List(-1, -2, -3) ::: list
    println(s"list:$list")
    println(s"list2:$list2")
    println(s"list3:$list3")
  }

  @Test
  def _for: Unit = {
    val result = for(i <- 1 to 10) yield i * 2
    println(s"result:$result")
    val result2 = for(i <- 1 to 10) i * 2
    println(s"result2:$result2")
  }

}
