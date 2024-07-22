package Week4.Mon

import scala.annotation.tailrec

object Recursion extends App {

  // Standard recursion
  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      println(s"Currently working on ${n - 1}")
      val finalResult = n * factorial(n - 1)
      println(s"I'm the final call on $n")
      finalResult
    }
  }
  println("\nFactorial method (4) - standard recursion:")
  println(factorial(4))

  // Tail recursion
  def smartFactorial(n: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        println(s"Current x: $x")
        println(s"Current acc: $acc")
        factorialHelper(x - 1, x * acc)
      }
    }
    factorialHelper(n, 1)
  }
  println("\nFactorial - tail recursion (4):")
  println(smartFactorial(4))

  // Tail recursive string concatenation
  @tailrec
  def concatenateWords(aWord: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateWords(aWord, n - 1, aWord + acc)
    }
  }
  println("\nTail recursive concatenate words:")
  println(concatenateWords("hello ", 3, "WORLD"))

  // List element counting - standard recursion
  def listContains(list: List[String]): Int = {
    if (list.isEmpty) 0
    else {
      1 + listContains(list.tail)
    }
  }
  val list = List("a", "b", "c")
  println(listContains(list))

  // List element counting - tail recursion
  def listContainsTailRec(list: List[String]): Int = {
    @tailrec
    def helper(remainingList: List[String], accumulator: Int): Int = {
      if (remainingList.isEmpty) accumulator
      else {
        helper(remainingList.tail, accumulator + 1)
      }
    }
    helper(list, 0)
  }
  println(listContainsTailRec(list))

  // List element counting - pattern matching
  def listContains1(list: List[String]): Int = list match {
    case head +: tail => 1 + listContains1(tail)
    case Nil => 0
  }
  println(listContains1(list))

  // List element counting - tail recursion with pattern matching
  def lisContainsTailMatch(list: List[String], acc: Int): Int = list match {
    case Nil => acc
    case head +: tail => lisContainsTailMatch(tail, acc + 1)
  }
  println(lisContainsTailMatch(list, 0))

  // Enumeration for days of the week
  object dayOfWeek extends Enumeration {
    type dayOfWeek = Value
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  // Convert list of enumerations to string
  def enumListToString(dayOfWeekEnums: List[dayOfWeek.Value]): String = {
    @tailrec
    def enumListHelper(dayEnums: List[dayOfWeek.Value], acc: String): String = {
      dayEnums match {
        case Nil => acc
        case head +: tail =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          enumListHelper(tail, acc + makeNiceToRead + head.toString)
      }
    }
    enumListHelper(dayOfWeekEnums, "")
  }




  /** Recursion with case objects */


  sealed trait DayOfWeek
  case object Monday extends DayOfWeek
  case object Tuesday extends DayOfWeek
  case object Wednesday extends DayOfWeek
  case object Thursday extends DayOfWeek
  case object Friday extends DayOfWeek
  case object Saturday extends DayOfWeek
  case object Sunday extends DayOfWeek


  def objectToString(listDays: List[DayOfWeek]): String = {
    def helperMethod(remainlingListDays: List[DayOfWeek], acc: String): String = {
      remainlingListDays match {

        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          helperMethod(tail, acc + makeNiceToRead + head.toString)


      }
    }
    helperMethod(listDays,"")
  }
  println("\n object to string " + objectToString(List(Monday, Tuesday, Wednesday, Thursday, Friday)))



  object Fruit extends Enumeration {
    type Fruit = Value
    val Apple, Orange, Banana, Mango, Grape = Value
  }


  import Fruit._

  def countFruit(fruits: List[Fruit], targetFruit: Fruit): Int = {
    def helperFruit(remainingFruitList: List[Fruit], acc: Int): Int = {
      remainingFruitList match {
        case Nil => acc
        case head :: tail =>
          val newAcc = if (head == targetFruit) acc + 1 else acc
          helperFruit(tail, newAcc)
      }
    }
    helperFruit(fruits, 0)
  }
  val fruitList = List(Apple, Orange, Banana, Apple, Mango, Apple, Grape, Banana)
  println(countFruit(fruitList, Orange))









}


