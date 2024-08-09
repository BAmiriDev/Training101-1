// Task la
//• Create a second function called 'applyTwice' that takes two arguments.
//• One of the arguments is an Int input.
//• The other argument is an Int to Int function (made in step one).
//• The applyTwice function must apply the Int to Int function argument twice to the Int argument.

//• Create a function that takes an Int input and manipulates it to return a different Int value.
def addOne(x: Int): Int = x + 1

//• Create a second function called 'applyTwice' that takes two arguments.
def applyTwice(x: Int, y: Int => Int): Int = {
  y(y(x))
}

val result = applyTwice(10, addOne)



//Task 1b
//• Create 4 functions (addition, multiplication, division, subtraction), each take two doubles as an input and return the result.
//• Create a function called 'mathFunc' that takes in two doubles, and a mathematical operation (as made above) as a function and returns the result as a double.

// Step 1: Create 4 functions (addition, multiplication, division, subtraction)
def addition(a: Double, b: Double): Double = a + b
def multiplication(a: Double, b: Double): Double = a * b
def division(a: Double, b: Double): Double = a / b
def subtraction(a: Double, b: Double): Double = a - b

// Step 2: Create a function called `mathFunc` that takes in two doubles and a mathematical operation
def mathFunc(a: Double, b: Double, function: (Double, Double) => Double): Double = {
  function(a, b)
}


// Test Task 1b
val add = mathFunc(5.0, 5.0, addition)
val multiply = mathFunc(9.0, 9.0, multiplication)
val divide = mathFunc(20.0, 5.0, division)
val subtract = mathFunc(100.50, 73.22, subtraction)

println(add)
println(multiply)
println(divide)
println(subtract)


// Task 2a


//• Create a function called 'convertToUpperCase' that take any string input, and returns that string as uppercase.
def convertToUpperCase(input: String): String = input.toUpperCase

//• Create a function called 'convertToLowerCase' that take any string input, and returns that string as lowercase.
def convertToLowerCase(input: String): String = input.toLowerCase


//• Create a third function called 'convertString' that takes a Boolean input with parameter name 'makeStringUpperCase'. If the input is 'true' return the lst upperCase method, if false return the 2nd lowerCase method.
def convertString(makeStringUpperCase: Boolean): String => String = {
  if (makeStringUpperCase) convertToUpperCase
  else convertToLowerCase
}

//• Copy: val testString = "cOnVeRtMe". Apply your convertString method to your testString and print the result when the input is 'true' and when it is 'false'.
val testString = "cOnVeRtMe"

// Convert to uppercase
val upperCaseFunction = convertString(true)
println(upperCaseFunction(testString))

// Convert to lowercase
val lowerCaseFunction = convertString(false)
println(lowerCaseFunction(testString))


//Task 2b


//• Create a 'calculate' method that takes a string input and pattern matches it to return one previously written methods from question 1; 'add', 'subtract', 'multiply', and 'divide'
def calculate(operation: String): (Double, Double) => Double = {
  operation.toLowerCase match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
  }
}



//• Try applying different string inputs to the calculate method to return each of the arithmetic methods, saving the resulting method to a val.
val addFunction = calculate("add")
val subFunction = calculate("subtract")
val mulFunction = calculate("multiply")
val divFunction = calculate("divide")

//• Apply the val methods (from above), passing in two Int values. Print the result using s interpolation.
val a = 20.0
val b = 10.0

println(s"Addition result: ${addFunction(a, b)}")
println(s"Subtraction result: ${subFunction(a, b)}")
println(s"Multiplication result: ${mulFunction(a, b)}")
println(s"Division result: ${divFunction(a, b)}")


// Task 1.



//• Create a function called "max" that takes two Doubles and returns the maximum of the two numbers. (HINT: research and use the method, max)
def max(a: Double, b: Double): Double = a max b//Math.max(a, b) or if (a > b) a else b

//• Create a function called "maxListNum" that takes a list of doubles and the "max" function. It should return the largest number in the list. (HINT: research and use the reduce) method)
def maxListNum(nums: List[Double], maxFunc: (Double, Double) => Double): Double = {
  nums.reduce(maxFunc)
}


val numList = List(1.1, 2.2, 3.3, 4.4)
val maxNum = maxListNum(numList, max)
println(maxNum)

// Task 2.

//• Create a function named 'applyFunc' that takes two parameters; a function of type Int => Int and an Int value. The 'applyFunc' should apply the function to the integer and return the result.
def applyFunc(function: Int => Int, x: Int): Int = function(x)

//• Create two functions, one named 'double' that doubles the input number, and one named 'square' that squares the input number.
def double(x: Int): Int = x * 2

// Function to square the input number
def square(x: Int): Int = x * x

//• Use the 'applyFunc' to apply the 'double' and 'square' methods to the number 5 and print the result.
val doubleResult = applyFunc(double, 5)
println(doubleResult)

val squareResult = applyFunc(square, 5)
println(squareResult)



// Task 3
//• Create a function named 'power' that takes an integer 'exponent' and returns a function Int => Int.
//The returned function should take a 'base' integer and raise it to the power of 'exponent'. (HINT: research and use Math.pow))
def power(exponent: Int): Int => Int = {
  base => Math.pow(base, exponent).toInt
}


