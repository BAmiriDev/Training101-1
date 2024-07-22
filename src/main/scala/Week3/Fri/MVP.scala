package Week3.Fri

import Week3.Thur.Extension._

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object MVP extends App{


  // Step 1: Implicit ExecutionContext
  implicit val ec: ExecutionContext = ExecutionContext.global

  // Step 2: Create a method called * fetchLetter
  //- It takes no parameters
  //- It should return a 'Future[Letter]', any letter will do
  def fetchLetter: Future[Letter] = Future {
    // Step 7: Simulate a long computation
    Thread.sleep(10000000)
    Letter(Name("henry"), Postcode("SE8 5AE"))
  }

  // Step 3: Use the Await.ready method like the following
  //- Await.ready(eventualLetter, 2.seconds)
  //- If this doesn't find an import for you, use 'import scala.concurrent.duration.
  val eventualLetter: Future[Letter] = fetchLetter

  // Step 4: Use Await.ready method
  Await.ready(eventualLetter, 2.seconds)

  // Step 5: 5. Extract the value from the future using value
  //- Match on the case: ' eventualLetter.value match {
  //- There should be the following cases
  //- 'Some(Success(foundLetter))* - The future completed with a value
  //- 'Some(Failure(exception))* - The future completed with an exception
  //- 'None - The future did not complete
  //- Add a printin to each of these cases
  eventualLetter.value match {
    case Some(Success(foundLetter)) =>  println(s"The future completed with a value: $foundLetter")
    case Some(Failure(exception)) => println(s"The future completed with an exception: $exception")
    case None => println("The future did not complete")
  }

  // Step 8: Run again and see the result
  // Remove or comment out the Thread.sleep(10000000) line to observe different behaviors

}
