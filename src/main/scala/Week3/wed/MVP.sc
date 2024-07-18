import java.time.LocalDate
//1. Using pattern matching, when given a string of the name of a country your pattern match should return that countries capital city.
//• Think about how you will deal with countries you have not included.
//• What happens when someone has entered a country in all lowercase/ uppercase or mixed?
//• What if the country has whitespaces either side of it (e.g." England ")?

val capitalCities: String = "  engLanD  "

//Trim White Spaces: Remove any leading or trailing white spaces.
//Convert to Lower Case: Convert the entire string to lower case.
//Capitalize: Capitalize the first letter of the resulting string.

capitalCities.trim.toLowerCase.capitalize match {
  case "England" => "London"
  case "Ireland" => "Dublin"
  case "Russia" => "Moscow"
  case "Algeria" => "Algiers"
  case _ => "Invalid Country"
}
//2. Given this data:
//• Full Name
//• Date of Birth
//• Occupation
//• Last Country lived in
//• Date of Death
//Only the fields Full Name, Date of Birth, Last Country lived in are required.
//Create a method that accepts the above data and makes a Person case class from this data.
//The Person case class should also include their age, star sign. If they have a dateOfDeath it should include their ageAtDeath.

case class InitialPerson(
                          fullName: String,
                          dateOfBirth: String,
                          lastCountryLivedIn: String,
                          occupation: Option[String] = None,
                          dateOfDeath: Option[String] = None
                        )



case class Person(
                   fullName: String,
                   dateOfBirth: String,
                   lastCountryLivedIn: String,
                   occupation: Option[String] = None,
                   dateOfDeath: Option[String] = None,
                   age: Int,
                   startSign: String,
                   ageAtDeath: Int

                 )

sealed trait StarSign

case object Aries extends StarSign

def calculateAge(birthDate: String, endDate: String): Int = {
  ???
}

def getStarSign(birthDate: String): String = {
  ???
}

def dateOfDeath(birthDate: String, deathDate: Option[String]): Option[Int] = {
  ???
}

def createPerson(input: InitialPerson): Person = {
  ???
}

//example of a tuple
//A tuple is a collection of elements of different types. You can access each element by its index
// Creating a tuple with a name and age
val person: (String, Int) = ("Alice", 30)

// Accessing the elements of the tuple
val name = person // "Alice"
val age = person._2 // 30


//3. Create a method called horoscope. This method should accept a LocalDate and return a tuple of their star sign and their horoscope. Use pattern matching in your method.
def horoscope(date: LocalDate): (String, String) = {
  val starSign = (date.getMonthValue, date.getDayOfMonth) match {
    case (1, d) if d >= 20 => "Aquarius"
    case (2, d) if d <= 18 => "Aquarius"
    case (2, d) if d > 18 => "Pisces"
    case (3, d) if d <= 20 => "Pisces"
    case (3, d) if d > 20 => "Aries"
    case (4, d) if d <= 19 => "Aries"
  }

  val horoscopeMessage = starSign match {
    case "Aquarius" => "you will be rich."
    case "Pisces" => "keep your enemy close."
    case "Aries" => "master your emotions."
  }

  (starSign, horoscopeMessage)
}
horoscope(LocalDate.of(2024, 1, 15))._1
horoscope(LocalDate.of(2024, 1, 15))._2




//4. a. Create an Animal that can then be extended by instances of animals.

//Hint - How can you make a trait that allows for exhaustive pattern matching?
//In Scala, you can make a trait that allows for exhaustive pattern matching by using sealed traits along with case objects and case classes. A sealed trait ensures that all implementations of the trait must be in the same file, which allows the compiler to know all the possible subtypes. This way, when you pattern match against the trait, the compiler can check that all possible cases are covered.

//c. Using pattern matching return a string with a facts about that animal. e.g. Pig -> "Can fly."
sealed trait Animal {
  val speciesName: String
}
//b. Create different types of Animals that extend Animal.
case object Dog extends Animal {
  val speciesName = "PitBull"
}
case object Cat extends Animal {
  val speciesName = "British ShortHair"
}
case object Pig extends Animal {
  val speciesName = "Wild Boar"
}
case object Rhino extends Animal {
  val speciesName = "Black Rhino"
}
//c. Using pattern matching return a string with a facts about that animal. e.g. Pig -> "Can fly."
val animaList: Animal = Rhino

val criticallyEndangered: List[String] = List("Black Rhino", "African forest Elephant", "Orangutan",
  "Hawksbill Turtle", "Sunda Tiger", "Javan Rhino")

animaList match {
  case Dog if Dog.speciesName == "PitBull" => "im a man best friend!" + s" ${Dog.speciesName}"
  case Cat if Cat.speciesName == "British ShortHair" => "i have 9 lives" + s" ${Cat.speciesName}"
  case Pig if Pig.speciesName == "Wild Boar" => "I don't sweat" + s" ${Pig.speciesName}"
  case endangered if criticallyEndangered.contains(endangered.speciesName) => s"${endangered.speciesName} critically endangered species"
  case _ => "invalid animal"
}

//Extension:
//1. A) Using pattern matching and if guards, add species Name to your previously created animals.
//
//e.g. A Whale could have the speciesName Blue whale, Fin Whale, Sei Whale...
//B) Given these list of endangered animals:
//val criticallyEndangered: List [String] = List("Black Rhino", "African forest Elephant", "Orangutan",
//"Hawksbill Turtle" "Sunda Tiger" "Javan Rhino")
//Add if statements (if guards) to your animal facts pattern match, if the speciesName matches one in the above list it should include the fact about that animals.
//e.g. Rhino with the speciesName Black Rhino would include the fact and return "The Black Rhino is a critically endangered species".

//
//def checkListType[T](list: List[T]) = list match {
//  case _: List[Double] => "List of Doubles"
//  case _: List[String] => "List of Strings"
//  case _: List[Int] => "List of Ints"
//  case _ => "Unknown"
//}
//// Hint - check out type erasure.
//val numList: List[Int] = List(1, 2, 3)
//val doubleList: List[Double] = List(1.0, 2.0, 3.0)
//val stringList: List[String] = List("1", "2", "3")
//checkListType(numList)
//checkListType(doubleList)
//checkListType(stringList)



