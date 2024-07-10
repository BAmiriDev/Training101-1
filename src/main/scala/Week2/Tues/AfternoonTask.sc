/**MVP*/
//1)Three main differences between class and case class
//Case Class: Automatically generates boilerplate or methods whereas you need to call
//Case Class: Instances can be used in pattern matching
//Case Class: Instances are by default immutable
//2)
// this should be okay
case class Person(name: String, age: Int, nationality: String, isStudent: Boolean)//works
val secondPerson = Person("Carlos", 23, "Spanish", true)// works
val firstPerson = new Person("Carlos", 23, "Spanish", true)// works but doesn't need new keyboard
val thirdPerson = Person("Chloe", 25, "British", false)// works

class Animal(name: String, colour: String, pet: Boolean) // works
//val cat = Animal("cat", "black", true)// need new keyword - error
val dog = new Animal("dog", "white", true)// works
//Compare
secondPerson  == firstPerson//true parameters are the same
secondPerson  == thirdPerson//false parameters are not the same
firstPerson  == thirdPerson//false parameters are not the same
firstPerson == dog//false unrelated types
dog == secondPerson//false unrelated types


case class Muffin (flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin ("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin ("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin ("choocolate", 2.50, "MercatorBakery")


chocolateMuffin == oneMoreChocolateMuffin//false parameter is same but string is in capital letter
chocolateMuffin == anotherChocolateMuffin//true same parameters
chocolateMuffin == finalChocolateMuffin//false different price
//rest should return false

/**EXTENSION*/
//1)Construct a case class that takes in a
//minimum of 3 parameters, each of a
//different type, and a case object.
case object practiceObj
case class practice(firstParam: String, secondParam:Int, thirdParam: Boolean)


//2)Create 3 instances of the case class.

val practice1: practice = practice("first",2,true)
val practice2: practice = practice("second",3,false)
val practice3: practice = practice("third",4,true)

//3) Use the ".copy" method to create a further
//3 instances, each time modifying a
//different class parameter.



val newPractice1: practice = practice1.copy("first copy")
val newPractice2: practice = practice2.copy("second copy", 20)
val newPractice3: practice = practice3.copy("third copy",30,false)


//4)4. Use the ".toString" method to print all
//parameters of the instance you have
//already created for exercise 3.
newPractice1.toString
newPractice2.toString
newPractice3.toString

//5)Use the ".equals" method to compare case
//class instances you have already created
//as part of the exercises so far.
newPractice1.equals(newPractice2)
newPractice1.equals(newPractice3)
newPractice2.equals(practice3)
newPractice3.equals(newPractice3)

/**RESEARCH*/
//1)We discussed about ".copy", ".toString"
//and ".equals" methods but there are a lot
//more available, such as ".getClass",
//"can Equal" etc. Find as many as you can,
//what do they do? Try to apply them the
//case classes you've created.

newPractice1.canEqual(practice2)
newPractice2.toString
newPractice2.hashCode()
newPractice1.productArity
newPractice1.productElement(0)
newPractice2.getClass
//2)Is there difference between ".equals" and
//"==" methods and why?

//the .equals() method and the == operator is that one is a method, and the other is the operator.
// null-safe, meaning it won't throw a NullPointerException if one of the objects is null
//This method checks if two objects are exactly the same



