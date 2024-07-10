/** With parentheses () */

//construct with no defined parameters
class Park1
//Make object
new Park1

//Construct with defined parameter
//we are not giving default values
//we don not have to put val or var
class Park2(val rollerCoaster: Boolean, val largestLoop: Double)
//Make an object
new Park2(rollerCoaster = true, largestLoop = 4.5)
new Park2(rollerCoaster = false, largestLoop = 23.95)
// extend Park2 class - must eneter values because i dont have defaults
object Disney extends Park2(rollerCoaster = true, largestLoop = 4.65)

//Abstract - if we are not giving default values but are giving defined paramaters
//by making it abstract - safety net

abstract class Park3(val coster: Boolean, val loop: Double)
//Make object - NOPE!
new Park3 // CANT DO THIS
// MUST BE EXTENDED in order to use them

//Constructing with default parameters
//Unlikely to change
class Park4(val coaster: Boolean = true, val loop: Double = 4.7 )
//Make an object
new Park4// would use default values
//do not need to use keyword override or val/var
//can override none, 1 , multiple
//if not overriding, do not include it
new Park4(coaster = false)// overridden - using default for the loop but has a override for coaster

/** With curly braces {} */
//No defined parameters
class Park5{}
//make object
new Park5

//constructed with defined parameters (but no default)-- NOPE, cant do this
//Make it anstract or give it defaults
class Park6{
  val coaster: Boolean
  val loop: Double
}
abstract class Park6{
  val coaster: Boolean
  val loop: Double
}

//Construct with default paramters
//New Line
//Must say val/var
class Park7{
  val coaster: Boolean = true
  val loop: Double = 5.6
}
//make object
val y =new Park7 //using of default parameters
//Can override these
new Park7{
  override val coaster: Boolean = false
}
y.coaster
y.loop
// We can extend
object legoLand extends Park7
legoLand.loop
//Override
object Legoland2 extends Park7{
  override val loop: Double = 3.5
}


/** Abstract Classes */

/** {} */
//Must use val / var
abstract class Park8 {
  val coaster: Boolean
  val loop: Double
}
//make object
new Park8 {
  override val coaster: Boolean = true
  override val loop: Double = 6.32
}
//When extending - must give a value to every parameter (even if it has a default )
object HydePark extends Park8{
  override val coaster: Boolean = false
  override val loop: Double = 0.0
}

/** () */
abstract class Park9(val coaster: Boolean, val loop: Double)
//Make object
new Park9()// - NOPE!
// Extend the class we can make an object
object AnotherNewPark extends Park9(coaster = true, loop = 4.7)

//What is accessible
//will lose access to parameters if you remove val/ var from abstract class with()
AnotherNewPark.coaster

/** () and {} */
abstract class Park10(val coaster: Boolean){
  val loop: Double = 7.6
}
new Park10 (coaster =   true)
//abstract class Park10(val coaster: Boolean){
//  val loop: Double = 7.6
//}
//new Park10(coaster =   true){
//  override val loop: Double = 6.4
//}

/** Trait */
//without defaults
trait CandyFloss{
  val hasCandyFloss: Boolean
}
object AnotherNewPark2 extends CandyFloss{
  override val hasCandyFloss: Boolean = true
}
//With default value
trait CandyFloss{
  val hasCandyFloss: Boolean = true
}
object AnotherNewPark3 extends CandyFloss //could still override in the same way as above

/** Sealed Keyword*/
//Only access in the same file
sealed abstract class AbstractClassThatIsSealed
sealed trait SealedTrait
//Allows for exhaustive matching (to be continued ....)


/** Case Classes  */

