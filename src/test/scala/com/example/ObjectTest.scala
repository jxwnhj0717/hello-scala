package com.example

import org.junit.jupiter.api.Test

/**
 * Scala实用指南第4章：处理对象
 */
class ObjectTest {

  /**
   * 构造函数
   */
  @Test
  def construct: Unit = {
    var car = new Car(2021)
    car.drive(100)
    println(s"car year:${car.year} miles:${car.miles}")
  }

  // 不需要单独定义构造函数，声明成员变量year
  class Car(val year : Int) {
    private var milesDriven : Int = 0

    def miles = milesDriven

    def drive(dis : Int): Unit = {
      milesDriven += Math.abs(dis)
    }

  }

  // 单例对象
  object Car {
    // 创建伴生对象
    def apply(year : Int): Car = new Car(year)
  }

  /**
   * 单例对象和伴生对象
   */
  @Test
  def singleObject: Unit = {
    // 实际调用了单例对象Car的apply方法，apply方法可以省略。类似构造List，List(1, 2, 3)也是调用了List.apply(1, 2, 3)
    var car = Car(2020)
    car.drive(200)
    println(s"car year:${car.year} miles:${car.miles}")
  }

  /**
   * 包对象
   */
  @Test
  def packageObject: Unit = {
    var s = "1"
    var i = converter(s)
    println(s"s class:${s.getClass}, i class:${i.getClass}")
  }

}
