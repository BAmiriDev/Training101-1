/** Higher Order Functions */

//what does it mean to be a first class citizen?
//we can:

//1. assign function to vals:
val addition: (Int, Int) => Int = (x,y) => x+y
addition(1,2)
val subtract: (Int, Int) => Int = (x,y) => x-y
//2. Store functions in collections (e.g. lists, maps, etc.)
val function = List(
  (a: Int, b : Int) => a + b,
  (a: Int, b : Int) => a * b,
  (a: Int, b : Int) => a - b,
)

function.head(1,2)
function(1)(1,2)
function(2)(1,2)

//3. pass functions into arguments or parameters/arguments
def manipulateNumbers (x:Int, y:Int, function:(Int, Int) => Int): Int = {
  function(x,y)
}
manipulateNumbers(1,2, addition)
manipulateNumbers(1,2,subtract)

//4. return finctions from other functions
def createAdditionFunction (x:Int): Int => Int = {
  println(s"$x")
  (y: Int) => x + y
}

createAdditionFunction(1)
val addOne: Int => Int =  createAdditionFunction(1)
addOne(2)

/** Functions as params */
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x)
}
def addTwo(n: Int): Int = n + 2
firstHOF(3,addTwo)
def square(n:Int): Int = n * n
firstHOF(3, square)

def processTheList(list1: List[String], function: String => String): List[String] = {
list1.map(function)
}

def addS(word: String): String = word + "s"
def upperCase(word: String): String = word.toUpperCase
val newList: List[String] = List("apple", "banana", "pear", "mango")
processTheList(newList, addS)
processTheList(newList, upperCase)

//map - common HOF
val numbers  = Seq(1,2,3,4,5)
val doubledNumbers = numbers.map(num => num * 2)

//foldLeft - used to reduce a collection into a single value.
val foldLeftExample  = numbers.foldLeft(0)(_ + _)// (_+_) - (acc + current value)

val stringList = List("we", "love", "scala")
val concatenatedString = stringList.foldLeft("")(_ +" "+ _).trim

//foldRight
val foldRightExample = numbers.foldRight(0)(_+_)
val concatenatedStringRight = stringList.foldRight("")(_ +" "+ _).trim


case class Male (male: Boolean)
case class Animal(name: String, male: Male)
val animalList = List(Animal("fred teh fox ", Male(true)), Animal("sally the seahorse", Male(false)), Animal("lucky the lion", Male(true)) )
val foldAnimalLeft = animalList.foldLeft((List[String]())) {(acc, animal )=>
  val sirOrMadam = animal.male match {
    case Male(true) => "sir"
    case Male(false) => "madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"

}
println(foldAnimalLeft)


val foldAnimalRight = animalList.foldRight((List[String]())) {(animal, acc )=>
  val sirOrMadam = animal.male match {
    case Male(true) => "sir"
    case Male(false) => "madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"

}
println(foldAnimalRight)


//1
val productOfList = numbers.foldLeft(1)(_ * _)// (_+_) - (acc * current value)
println(productOfList)

// 2.
def trueInt(x: Int): Boolean = x.isInstanceOf[Int]
val checkNum = numbers.filter(trueInt)
println(checkNum)


// 1.
val numOfChars = stringList.foldLeft(0)((acc, str) => acc + str.length)
println(numOfChars)

// 2.
val capitalLetter = stringList.map(acc => acc.capitalize).foldLeft("")(_+" "+_)
println(capitalLetter)

/** Returning functions */


def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1 // 10% increase
}

def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.2 // 20% increase
}

def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.5 // 50% increase
}

case class Employee(name: String, salary: Double, lengthOfEmployment: Int )

def getPayRise(employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    case year if year <= 3 => smallRise(employee.salary)
    case year if year <= 5 => mediumRise(employee.salary)
    case year if year > 5 => largeRise(employee.salary)
  }
}

val Amanda = Employee("Amanda", 30000.0, 2)
val choosePayRise = getPayRise(Amanda)
val getNewSalary = choosePayRise(Amanda.lengthOfEmployment, Amanda.salary)

//Task

def smallDiscount(price: Double): Double = {
  price * 0.8 // 20% discount
}

def mediumDiscount(price: Double): Double = {
  price * 0.6 // 40% discount
}

def largeDiscount(price: Double): Double = {
  price * 0.5 // 50% discount
}

def getDiscountFunction(price: Double): Double => Double = {
  price match {
    case item if item < 20 => smallDiscount
    case item if item >= 20 && item <= 50 => mediumDiscount
    case item if item > 50 => largeDiscount
  }
}


val item1 = 20.0
val item2 = 10.50
val item3 = 100

// Apply the discount function to get the final price
val applyMidDiscount = getDiscountFunction(item1)
val applyLowDiscount = getDiscountFunction(item2)
val applyHighDiscount = getDiscountFunction(item1)
val finalPrice = applyMidDiscount(item1)





