package Week4.Mon

import scala.annotation.tailrec

object CheckEvenRecursion extends Enumeration {

  val numbers: List[Int] = (1 to 20).toList

  def isEvenAtIndex(index: Int): Either[String, Boolean] = {
    def helper(remainingList: List[Int], acc: Int): Either[String, Boolean] = {
      remainingList match {
        case Nil => Left(s"Index $index is out of bounds.")
        case head :: tail =>
          if (acc == index) Right(head % 2 == 0)
          else helper(tail, acc + 1)
      }
    }
    helper(numbers, 0)
  }

  // Test the function
  println(isEvenAtIndex(3))  // Right(true) because 4 is even
  println(isEvenAtIndex(4))  // Right(false) because 5 is odd
  println(isEvenAtIndex(21)) // Left("Index 21 is out of bounds.")




}
