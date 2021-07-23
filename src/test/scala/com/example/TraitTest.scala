package com.example

import org.junit.jupiter.api.Test

import java.util

/**
 * Scala实用指南第7章：特质
 */
class TraitTest {

  /**
   * 选择性混入
   */
  @Test
  def selectiveMixing: Unit = {
    val list = new util.ArrayList[Int]() with Car
    list.drive
  }

  trait Car {
    def drive: Unit = {
      println("drive car")
    }
  }

}
