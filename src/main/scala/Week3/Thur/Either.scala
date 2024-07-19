package Week3.Thur

import java.time.LocalDate

object Either extends App {

  // Left - error
  // right - success

  def isEven(x: Int): Either[String, String] =
    if (x % 2 == 0) Right(s"$x is even") else Left(s"$x is odd")

  println(isEven(4))
  println(isEven(7))

  // Custom error
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError(400, "bad request in the is odd method")

  def isOdd(x: Int): Either[NewError, String] =
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(4)) // error
  println(isOdd(7)) // right

  /** Try/Catch */
  def plusOne(x: String): Either[String, Int] = {
    try {
      Right(x.toInt)
    } catch {
      case e: Exception => Left(s"Failed due to: $e") // wildcard
    }
  }
  println(plusOne("1")) // Right - try
  println(plusOne("one")) // Left - catch

  // functions directly
  plusOne("3").map(num => num + 1)
  // plusOne("i will fail").map(num => num + 1)

  /** Pattern Matching */
  def plusOneMatch(): Unit = {
    plusOne("one") match {
      case Left(e) => println(s"Left: $e")
      case Right(x) => println(s"Right: $x")
    }
  }
  println(plusOneMatch())

  /** for comps with eithers */
  // fail fast - as soon as one condition is not met = exit

  case class User(username: String, password: String, dateOfBirth: LocalDate)

  case class ValidatedUser(username: String, password: String, dateOfBirth: LocalDate)

  // Validate the username
  def validateUsername(usernmae: String): Either[String, String] = {
    if (usernmae.length < 12) Left("username must vbe at least 12 characters")
    else Right(usernmae)
  }
  // Validate the password

  def validatePassword(password: String): Either[String, String] = {
    if (password.toUpperCase == password || password.toLowerCase == password) Left("Password must be a mixture of upper or lower case")
    else Right(password)
  }

  // validate the age
  def valifateAge(dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left("user must be 18 years old") else Right(dateOfBirth)
  }

  // combine all 3 and validate whole user as for comp

  def validatedUser(user: User): Either[String, ValidatedUser] =
    for {
      username <- validateUsername(user.username)
      password <- validatePassword(user.password)
      dob <- valifateAge(user.dateOfBirth)
      createValidatedUser = ValidatedUser(username, password, dob) // creation of the case class
    } yield createValidatedUser

  val usernameBad = User("april", "Password", LocalDate.of(1994, 4, 30))
  val passwordBad = User("aprilgar", "password", LocalDate.of(1994, 4, 30))
  val dobBad = User("aprilgar", "password", LocalDate.of(2024, 4, 30))
  val gooduser = User("aprilgarlinton", "password", LocalDate.of(1994, 4, 30))

  println(validatedUser(usernameBad))
  println(validatedUser(passwordBad))
  println(validatedUser(dobBad))
  println(validatedUser(gooduser))

}
