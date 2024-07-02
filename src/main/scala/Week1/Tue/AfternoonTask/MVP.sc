
/*Afternoon task
  MVP:
*/

//a) Three plus four, times fifty-seven is less than three-hundred
(3 + 4) * 57 < 300
//  b) One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
154 / 12 >= 12
//c) Cat is less than Dog (strings)
"Cat" < "Dog"
//d) Rabbit is less than Hamster (strings)
"Rabbit" < "Hamster"
//Seventeen is odd (modulus)
17 % 2 != 0
//f) Seventy-five divided by nine is less than thirty and eighty- nine divided by six is less than twenty
75 / 9 < 30 && 89 / 6 < 20

// 2. What is the difference between a string (e.g. "I love scala already") and a print line (e.g. println ("I love scala already") )? 3. Have a play in a scala worksheet using everything we have learnt today. What is possible? What isn't? Is there anything that you have done that you think is pretty cool or that's strange?

"I love Scala already" // Scala automatically treats this as a String value.
println("I love Scala already") // Prints the string to the console without assigning or storing it in a val.
//3. Have a play in a scala worksheet using everything we have learnt today. What is possible? What isn't? Is there anything that you have done that you think is pretty cool or that's strange?

val play1: Int = 240/2
val play2: Int = 20 * 2
val dev = play2 / play1

val result = play1> dev && play2 < dev

play1 > 100 || play2 < 100

val people1:String = "moe"
val age: Int = 25

println("hi my name is " + people1 + " and my age is "+ age)

age == 25



//Extension:

//  "STRING" == "string"
//1)True or false? Why?
"STRING" == "string" //it would return false because Scala performs case-sensitive comparisons when using the equality operator (==)

//2)Can you convert "one" to 1?

val op1:String = "one"
//op1 = cant be changed as it need to return a string

//3)Can you convert 1 to "one"?


val intToStr: Int = 1
val convert2 = intToStr.toInt // Cant return a lettered string to a int

//4.Can you convert 1 to a string? Is the result as you would expect?

val one: Int = 1
val convert: String = one.toString// uses the toString methods to convert the type Int to type String
println(convert)

val str: String = "1"
val convert1: Int = str.toInt// is also able to do it other way round


//5)Convert a lowercase string to uppercase.
val lowerCase: String = "helloworld"
println(lowerCase.toUpperCase())
//6.Convert on the first letter of a string to uppercase.
println(lowerCase.head.toUpper + lowerCase.tail) // .head selects the head of the string or first letter and .toUpper turns it to a capital letter. the lowerCase.tail return all the letter from the second letter onwards




/*Research:
  Make a val called new which is type string.
Why doesn't this compile?
What do we need to do within our code to make it work?
  Are there any other words that you cannot use?*/


//val new: String = " food"
//error, it doesn't accept identifier
// new is a scala keyword and is used create new instances
val corrected: String = " food "
