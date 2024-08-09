package Week4.Mon

import Week4.Mon.MVP.Euro2024Teams.Euro2024Teams

import scala.annotation.tailrec

object MVP extends App {

  // 1. Create an object that extends Enumeration. Provide all the teams participating in the Euro 2024. Now write a tail recursive method to print all the teams.

  object Euro2024Teams extends Enumeration {
    type Euro2024Teams = Value
    val Germany, France, Spain, Italy, Portugal, Netherlands, England, Belgium = Value
  }

  def printTeams(teams: List[Euro2024Teams]): String = {
    @tailrec
    def helper(remainingTeams: List[Euro2024Teams], acc: String): String = {
      remainingTeams match {
        case Nil => acc
        case head :: tail =>
          helper(tail, acc + head.toString + "\n")
      }
    }
    helper(teams, "")
  }

  val euroTeams = List(Euro2024Teams.Germany, Euro2024Teams.France, Euro2024Teams.Spain)
  println(printTeams(euroTeams))

  // 2. Now can you do the same as Question 1, but instead of using Enumeration, implement it using case objects. Make a sealed class of Team which has a constructor parameter 'name' which is type string and a companion object with the same name. Enter the case objects inside the companion object. What do you notice about accessing the values?

  sealed class Team(val name: String)

  case object England extends Team("England")
  case object France extends Team("France")
  // Add other teams similarly...

  object Team {
    val allTeams = List(England, France /*, add other teams here... */)

    def printTeams(teams: List[Team]): String = {
      @scala.annotation.tailrec
      def helper(remainingTeams: List[Team], acc: String): String = {
        remainingTeams match {
          case Nil => acc
          case head :: tail =>
            helper(tail, acc + head.name + "\n")
        }
      }

      helper(teams, "")
    }
  }

  println(Team.printTeams(Team.allTeams))

  // 3. Using recursion and given a list with all integers from 1 to 20 inclusive, create a method called "isEven" that checks if a number, at a given index position, is even or not. The return type of this method should be Either[String, Boolean].

  object CheckEvenRecursion {

    val numbers: List[Int] = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    def isEven(num: Int): Either[String, String] = {
      def helper(remainingList: List[Int], acc: Int): Either[String, String] = {
        remainingList match {
          case Nil => Left(s" $num is  of odd.")
          case head :: tail =>
            if (num % 2 == 0) Right(s"$num is even")
            else helper(tail, acc + 1)
        }
      }
      helper(numbers, 0)
    }

  }

  println(CheckEvenRecursion.isEven(3))
  println(CheckEvenRecursion.isEven(4))


  // Task 4: Sum of all numbers between 0 and a given number using recursion
  @tailrec
  def sumOfNum(x: Int, acc: Int = 0): Int = {
    if (x <= 0) acc
    else sumOfNum(x - 1, acc + x)
  }

  // Test the function
  println(sumOfNum(5))

}
