// Classes
// Capital for the name
// decalare using 'class'
// act as blueprint

///first way - unimplemented members
class ThemeParkEmptyParams(val hasRollerCoaster: Boolean, val diameterOdLargestLoop: Double)

// Second way - implemented members
//{} braces used here
//default params
class ThemeParkDefaultParams {
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 30.24
}
// everything inside the {} belongs to that class. Known as member of the class

class ThemeParkBoth (diameterOdLargestLoop: Double){
  val hasRollerCoasters: Boolean = true
}

// use classes to make objects

/** Objects */
// key word - new
  //EMPY PARAM
val mercatorPark: ThemeParkEmptyParams = new ThemeParkEmptyParams(hasRollerCoaster = true, diameterOdLargestLoop = 7.95)
mercatorPark.getClass
mercatorPark.hasRollerCoaster

//default param
val disneyWorld: ThemeParkDefaultParams = new ThemeParkDefaultParams()
disneyWorld.diameterOfLargestLoop
disneyWorld.hasRollerCoasters

/** Paramaters */
// Meaningful name
// raw values or existing vals can be passed in

class Hamster (age: Int, val colur: String)
val orange: String = " oranage"
//make hamster object
val BootheHamster: Hamster = new Hamster(1,orange)

/** Objects without classes*/
// when we only need 1 of something
//dont use the new keyword
// have no param
// Available globally

object DavidDogs {
  val Loki: String = " Loki "
  val Tayamul: String = "Tayamul "
  val Isla: String = "isla"
  val Bilal: String = "Bilal"
  val Oscor: String = "Oscar"
}
DavidDogs.Loki
DavidDogs.Bilal

/** Inheritance */
// use the 'extends; keyword
//deckare the class we want to extends
//class we extends from us called 'parent; or the 'superclass'
// can only extends one class

//class Bakken extends ThemeParkDefaultParams{
//  override val diameterOfLargestLoop: Double = 20.15
//  val oldestThemePark: Boolean = true
//
//}

class Bakken extends ThemeParkEmptyParams(true,diameterOdLargestLoop = 20.15) {
  val oldestThemePark: Boolean = true

}

/** Traits */
//keyword - with
// extends multiple traits
// traits can have unimplemented members
// we cannot create an instance if a trait (like we cab a class)
// use in combination with something else

trait Mascot {
  val nameOfMainCharacter: String
}

trait OversizedFood {
  val hugeTurkeyLeg: Boolean
}

class DisneyWorld extends  ThemeParkDefaultParams with Mascot with OversizedFood {
  override val nameOfMainCharacter: String = "Mickey"
  override val hasRollerCoasters: Boolean = false
  override val hugeTurkeyLeg: Boolean = true

}


trait FamilyMember {
  def name: String
  def surname: String


}
