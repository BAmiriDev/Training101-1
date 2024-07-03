/*MVP:

John from primary school maths is trying to buy as many watermelons as possible and we need to give him a reality check. John can reasonably carry 3 watermelons without a bag, and 5 with one bag.*/


//1)Create a value to store a number of watermelons
val watermelons: Int = 100

//2) Use an if statement to print out appropriate messages
if (watermelons <= 3) {
  println("doesn't need a bag")
} else if (watermelons <= 5) {
  println("needs a bag")
} else {
  println("can't carry them")
}

//3): String interpolation to add the number of watermelons to each message
if (watermelons <= 3) {
  println(s"John is trying to carry $watermelons watermelons, so he doesn't need a bag")
} else if (watermelons <= 5) {
  println(s"John is trying to carry $watermelons watermelons, needs a bag")
} else {
  println(s"John is trying to carry $watermelons watermelons, can't carry them")
}

// Task 4: Value to store whether John has a bag
val hasBag: Boolean = true

//5) can or cannot buy the desired number of watermelons in Task 1

if (watermelons > 0 && watermelons <= 3 || ( watermelons > 3 && watermelons <= 5  && hasBag)) {
  println(s"John can buy $watermelons watermelons")
} else {
  println(s"John can't buy $watermelons watermelons")
}

//6)total cost of John's purchase to 2 decimal places

val price: Double = 1.397
val totalPrice = watermelons * price

printf("total price = £%.2f", totalPrice)

//EXTENSION
//1) On the official scala website you can find the Logical Operators order of precedence https://www.scalasos.com/others/operator-precedence-in-scala/
//2)
true || false && false // This would return true because (&&) takes precedence and (false && false) return false, making it (true||false) returning true
(true || false) && false // in this case the parentheses is check first return true, then (true && fale) return flase
1 < 4 && 7 != 10 || 9 + 10 == 21// 1< 4 return true, 7 != 10 return true || 9 + 10 == 21 returns false. Turning the expression (true && true || false) --> (true || false) returning true


/*Research:
  If statements always return values. This means we can assign values based on if statements.
  How would we go about doing this, or where could we search to find out? Try out the example below:
  Create two values that hold integers. Assign any integer you'd like to these values.
  Create a new value to hold a string, and assign it "yes" if the first value is greater than the second, and "no" if the second value is greater.*/

//found a similar example of assigning if statement to val
//https://www.baeldung.com/scala/conditional-expressions#:~:text=Using%20an%20if%20expression%20is,val%20instead%20of%20a%20var.

val first: Int = 20
val second: Int = 25
val check: String = if (first > second) {
  "yes"
} else {
  "no"
}







