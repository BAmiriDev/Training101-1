package Week3.Fri

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import Week3.Thur.Extension._

case object Extension extends App {
  // 1. Create a method called * fetchLetterOrError*
  // - It should take a *(name: String, postCode: String)*
  // - The return type should be 'Future[Either[GenericPostageError, Letter]]'
  // - Use the 'letterOrError' method you made

  def fetchLetterOrError(name: String, postCode: String): Future[Either[GenericPostageError, Letter]] = Future {
    Letter.letterOrError(name, postCode)

  }

  // 2. Create a value called 'eventualLetterOrError'
  // - Call the 'fetchLetterOrError' to construct it and make it valid to begin with
  val eventualLetterOrError = fetchLetterOrError("Test Name"," Test Postcode")

  //3. Similar to before, use the value method and match off the cases
//  eventualLetterOrError match {
//    case ??? => println("","")
//
//  }
}

