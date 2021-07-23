package com.example

import org.junit.jupiter.api.Test

import java.time.LocalDate

/**
 * Scala实用指南第5章：善用类型
 */
class TypeTest {

  /**
   * 隐式函数
   */
  @Test
  def implicitFunction: Unit = {
    // 定义隐式函数
    implicit def convertInt2DateHelper(offset : Int) : DateHelper = new DateHelper(offset)

    val ago = "ago"
    val from_now = "from_now"

    // 2通过隐式函数转换成了DateHelper类型，等价于new DateHelper(2).days(ago)
    2 days ago
    2 days from_now
  }

  private class DateHelper(offset : Int) {
    def days(when : String) : LocalDate = {
      val today = LocalDate.now
      when match {
        case "ago" => today.minusDays(offset)
        case "from_now" => today.plusDays(offset)
        case _ => today
      }
    }
  }

  /**
   * 隐式类
   */
  @Test
  def implicitClass: Unit = {
    import DateHelperClass._
    // 2通过隐式类转换成了DateHelper类型，等价于new DateHelper(2).days(ago)
    2 days ago
    2 days from_now
  }

  object DateHelperClass {
    val ago = "ago"
    val from_now = "from_now"

    implicit class DateHelper(offset : Int) {
      import java.time.LocalDate

      def days(when : String) : LocalDate = {
        val today = LocalDate.now
        when match {
          case "ago" => today.minusDays(offset)
          case "from_now" => today.plusDays(offset)
          case _ => today
        }
      }
    }
  }


}
