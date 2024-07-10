/** Functions ansd Methods*/

//Functions
// Assigned to a val
//also methods
// no different to any other type
// dont havr to name them(however if we dont, they aren't reusable )

//Methods
//keyword 'def'
//belong to class
//can be overridden
//must be named

//anonymous function
(number: Int) => number + 1

//Named function
val addition: Int => Int = (number: Int) => number + 1


//Methods (also a function)
def addition: Int => Int = (number: Int) => number + 1

//override methods
def addition: Int => Int = (number: Int) => number + 10

// example method
def makeACupOfTea(numberOfSugars: Int): String = {
  true
  2345
  val cuppa = " tea "
  s" You have made a tea with $numberOfSugars spoons of sugar. Enjoy"
}
//dont have to give paramaters
//Calling this method
makeACupOfTea(2)

val aValue = (2<4)

val aDifferent = if(aValue) 564 else 24

//VAT method
val vat: Double = 1.4
def priceWithVAT(price:Double ): Double = {
  price * vat
}
priceWithVAT(5)

//Methods within a class
class Number(num:Int){
  def addition(aDifferentNum: Int): Int = {
    num + aDifferentNum
  }
}

val newNumberClass = new Number(10)
val classAddition = newNumberClass.addition(7)

def getBigVal(input1: Int, input2: Int): String = {
    if(input1 > input2) {
      "first"
    } else if (input1 < input2){
      "second"
    }else if (input1 == input2){
      "same"
    } else{
      "invalid"
    }
}

getBigVal(2,5)

def nameLength(firstName: String, surName: String): Int = {
  if (firstName.length >= surName.length) {
    firstName.length
  } else {
    surName.length
  }
}



nameLength("tom", "hiddleston")

/**PURE*/

val sentence:String = ""
def append(sentence:String, word:String): String = {
  sentence + " " + word.trim
}
val a = append(sentence, "allo")
val b = append(sentence, "allo")

/**impure */
var sentence: String = ""

def append(word: String): String = {
  sentence = sentence + " " + word
  sentence = sentence.trim
  sentence
}

val a = append("allo")
val b = append("allo")




//Aim for pure