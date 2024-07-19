package Week3.Thur

object ForComp extends App {


  // <-

  /** Classic */


  def retriveNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers

  println(retriveNumbers)


  def sqaureNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers * numbers

  println(sqaureNumbers)

  def ifguardNumbers: Seq[Int] = for (numbers <- 1 to 10 if numbers % 2 == 0) yield numbers

  println(ifguardNumbers)

  /** use with case classes */
  sealed trait Colour

  case object Blue extends Colour

  case object Green extends Colour

  case object Yellow extends Colour

  case class Pencil(colour: Colour, sharpened: Boolean)

  def getPencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

  println(getPencils)

  def getTruePencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

  println(getTruePencils)



  //task 1


  def capitalNames: List[String] = for {
    name <- List("moe", "joe", "lee")
  } yield name.toUpperCase

  println(capitalNames)

//task 2
  def capitalFirstLetterNames: List[String] = for {
    name <- List("moe", "joe", "lee")
  } yield name.toLowerCase.capitalize

  println(capitalFirstLetterNames)

}