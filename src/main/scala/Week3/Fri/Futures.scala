package Week3.Fri

//for future - global = lazy val
import Week3.Thur.Either.{NewError, isOdd}

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.Success

object Futures extends App {

  //act as a placeholder
  def addition(x: Int, y: Int): Int = {
    Thread.sleep(1000) // Long computation type
    x + y
  }

  def addtionInTheFuture: Future[Int] = Future {
    addition(1,2)
  }

  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS)

  println(Await.result(addtionInTheFuture, waitTime))



  def fetchIsOddOrError(num:Int): Future[Either[NewError, String]] =
    Future {
      Thread.sleep(1000)
      isOdd(num)
    }

  def eventualIsOddOrError: Future[Either[NewError, String]] =
    fetchIsOddOrError(4)

  val matchFutures = eventualIsOddOrError

  def matchIsOddError: String = eventualIsOddOrError.value match {
    case Some(Success(complete)) => s"Future completed: $complete"
    case None => "Future did not complete in the given time"
  }

  println(Await.ready(eventualIsOddOrError, waitTime))



}
