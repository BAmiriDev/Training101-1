/*a) Make a List of the numbers from 1-5, and a Seq of the primary colours.
b) Multiply all the values in your List by 3.
c) Remove “Blue” from your Seq.
d) Returns ‘true’ if your Seq contains “Orange”*/

val numList: List[Int] = List(1,2,3,4,5)
val primaryColours: Seq[String] = Seq("Red", "Blue", "Yellow")

val multiplyList: List[Int] = numList.map {
  numbers => numbers * 3
}
val removeBlue: Seq[String] = primaryColours.filterNot{
  blue => blue.contains("Blue")
}

val findOrange: Boolean = primaryColours.contains("Orange")