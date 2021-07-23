package com.example

import org.junit.jupiter.api.Test

/**
 * Scala实用指南第6章：函数值和闭包
 */
class FunctionTest {

  /**
   * 柯里化
   */
  @Test
  def currying: Unit = {
    val list = List(1, 2, 3, 4, 5)
    var sum = 0
    list.foreach(i => {sum += i})
    //foldLeft方法的作用就是遍历集合，执行指定函数的逻辑，指定函数是foldLeft方法的一个参数列表，可以写在()中，也可以写在{}中
    val sum2 = list.foldLeft(0)((a, b) => a + b)
    val sum3 = list.foldLeft(0){(a, b) => a + b}
    println(s"sum: $sum, sum2: $sum2, sum3: $sum3")
  }

  /**
   * 参数的占位符
   */
  @Test
  def placeholderForParameters: Unit = {
    val list = List(1, 2, 3, 4, 5)
    val sum = list.foldLeft(0){_ + _}
    println(s"sum: $sum")
  }

  /**
   * 部分应用函数
   */
  @Test
  def partiallyAppliedFunction: Unit = {
    var aFunc = func(1, _, _)
    var abFunc = aFunc(2, _)
    println(s"aFunc:$aFunc, abFunc:$abFunc")
    var abc = abFunc(3)
    println(s"abc:$abc")
  }

  private def func(a : Int, b : Int, c : Int): Unit = {
    println(s"a:$a, b:$b, c:$c")
  }

}
