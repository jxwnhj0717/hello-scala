package com.example

import org.junit.jupiter.api.Test

import scala.io.Source

/**
 * Scala实用指南第12章：惰性求值和并行集合
 */
class LazyAndParallelTest {

  @Test
  def lazyVar: Unit = {
    lazy val i = retInt()
    println("do something")
    // 使用变量i时才计算retInt()
    println(s"i: $i")
  }

  def retInt(): Int = {
    println("retInt")
    10
  }

  @Test
  def lazyCollection: Unit = {
    val person = List(("Frank", 20), ("Jane", 22), ("John", 24), ("Will", 26))
    println(person.filter{isOlderThan17}.filter{isNameStartsWithJ}.head);
    println("========================")
    // view()返回集合的惰性视图，减少不必要的计算
    println(person.view.filter{isOlderThan17}.filter{isNameStartsWithJ}.head);
  }

  def isOlderThan17(person : (String , Int)) = {
    println(s"isOlderThan17 called for $person")
    person._2 > 17
  }

  def isNameStartsWithJ(person : (String, Int)) = {
    println(s"isNameStartsWithJ called for $person")
    person._1 startsWith("J")
  }

  @Test
  def parallelCollection: Unit = {
    val urls = List("https://www.baidu.com", "https://www.google.com", "https://bing.com", "https://spring.io", "https://github.com")
    var t1 = System.nanoTime();
    var size = urls.map(contentSize).foldLeft(0){_ + _}
    var t2 = System.nanoTime()
    println(f"[seq]totalSize: $size, time:${(t2 - t1) / 1E9}%.2fs")

    // par()将集合转成并行版本
    t1 = System.nanoTime();
    size = urls.par.map(contentSize).foldLeft(0){_ + _}
    t2 = System.nanoTime()
    println(f"[par]totalSize: $size, time:${(t2 - t1) / 1E9}%.2fs")
  }

  def contentSize(url : String) : Int = {
    val size = Source.fromURL(url)("UTF-8").mkString.size
    println(s"url: $url, size: $size, thread:${Thread.currentThread()}")
    size
  }


}
