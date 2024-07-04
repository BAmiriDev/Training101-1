
//TASK 1
//a) Make a List of the numbers from 1-5, and a Seq of the primary colours.
val numList: List[Int] = List(1, 2, 3, 4, 5)
val primaryColours: Seq[String] = Seq("Red", "Blue", "Yellow")
//b) Multiply all the values in your List by 3.
val multiplyList: List[Int] = numList.map {
  numbers => numbers * 3
}
//c) Remove “Blue” from your Seq.
val removeBlue: Seq[String] = primaryColours.filterNot {
  blue => blue.contains("Blue")
}
//d) Returns ‘true’ if your Seq contains “Orange”*/
val findOrange: Boolean = primaryColours.contains("Orange")

//TASK 2
//Go through each value in your List of numbers and return true if they are odd and false if they are even.

val check: List[Boolean] = numList.map {
  numbers => numbers % 2 != 0
}
//TASK 3
//David has a lot of pets. Decide what pets he has (must include at least 1 dog) and write these in a Map.
val pets: Map[String, String] = Map(
  "bird" -> "ben",
  "dog" -> "rocky",
  "cat" -> "leo",
  "hamster" -> "nis"
)
//TASK 4
//Return a List of the names of David’s dog(s).
val dogsNames: List[String] = pets.collect {
  case ("dog", name) => name
}.toList


//EXTENSION

//1)Starting with a Seq(1-9), come up with 2 filters that, when used together, will return Seq(1,2,5,7).
val numbers: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)

// First filter: removing numbers 3 and 4
val filtered1 = numbers.filterNot(num => num >= 3 && num <= 4)

// Second filter: Removing numbers 6,8 and 9 from the result of the first filter
val filtered2 = filtered1.filter(num => num != 6 && num != 8 && num != 9)


//2)The .head function returns the first element of a list, and the .tail function returns everything except the first element. Use head and tail only to get the 3rd element of a List.
val list = List(1, 2, 3, 4, 5)

val thirdElement = list.tail.tail.head // tail returns everything but the head giving 3,4,5 and then head returns 3
val thirdElement = list.drop(2).head // another way of doing it, drops the first two elements




/*Research:
 1) What makes a Set different from a Seq? What should Set(1,2) == Set(2,1,1,1) return?
// wont allow duplicate
//Not in order


 2) What do you think List(3,4) == Seq(3,4) will return? Why?
    What about List(5,6) == Set(5,6)?*/


//all of these return are false because you cant compare set to seq
Set(2, 2) == Seq(2, 1, 1, 1)
Set(3, 4) == Seq(3, 4)
Set(5, 6) == Seq(5, 6)





