// Finite sets of data

/** Native */
object Weekday extends  Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}
Weekday.Monday.toString

object BetterWeekday extends Enumeration {
  val Monday = Value("Mon")
  val Tuesday = Value("Tues")
  val Wednesday = Value("Wed")
  val Thursday = Value("Thur")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}

BetterWeekday.Thursday
BetterWeekday.values
Weekday.Monday < Weekday. Sunday // ordered by index position

object ReOrderWeekday extends Enumeration {
  val Monday = Value(1)
  val Tuesday = Value(2)
  val Wednesday = Value(3)
  val Thursday = Value(4)
  val Friday = Value(5)
  val Saturday = Value(6)
  val Sunday = Value(0)
}
ReOrderWeekday.values

def exhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "mon"
    case BetterWeekday.Tuesday => "tue"
    case BetterWeekday.Wednesday => "wed"
    case BetterWeekday.Thursday => "Thu"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
  }
}
// be careful
def nonExhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "mon"
    case BetterWeekday.Tuesday => "tue"

  }
}

/** Sealed case objects */
sealed trait Weekday
case object Monday extends Weekday
case object Tuesday extends Weekday
case object Wednesday extends Weekday
case object Thursday extends Weekday
case object Friday extends Weekday
case object Saturday extends Weekday
case object Sunday extends Weekday

def casePbjectMatch(weekday1: Weekday): String = {
  weekday1 match {
    case Monday => "m"
    case Tuesday => "t"
    case Wednesday => "w"
    case Thursday => "t"
    case Friday => "f"
    case Saturday => "s"
    case Sunday => "su"
  }
}
// must be exhaustive - will see compilation warning if not
// no easy way to access all values
//mo default ordering

abstract class Error (name: String, errorCode: Int)
case object WeekdayNotFound extends Error("weeday noy found", 404)

object Months extends Enumeration {
  val January, February, March, April, May, June, July, August, September, October, November, December = Value
}

Months.values

sealed trait Months
case object January extends Months
case object February extends Months
case object  March extends Months
case object  April extends Months
case object May extends Months
case object June extends Months
case object July extends Months
case object August extends Months
case object September extends Months
case object November extends Months
case object December extends Months

val printMonths: String = ???
