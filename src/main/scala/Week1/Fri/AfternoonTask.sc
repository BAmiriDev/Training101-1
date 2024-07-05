// Define the sealed trait for DietType
sealed trait DietType
case object Herbivore extends DietType
case object Carnivore extends DietType
case object Omnivore extends DietType

// Base class Animal with additional parameter diet
class Animal(val name: String, val age: Int, val diet: DietType)

// Mammal class extending Animal with additional properties
class Mammal(name: String, age: Int, val furColor: String, val hasTail: Boolean, diet: DietType) extends Animal(name, age, diet)

// Bird class extending Animal with additional properties
class Bird(name: String, age: Int, val beakLength: Int, val featherColor: String, diet: DietType) extends Animal(name, age, diet)

// Insect class extending Animal with additional properties
class Insect(name: String, age: Int, val numOfLimbs: Int, diet: DietType) extends Animal(name, age, diet)

// Warthog class extending Mammal with additional properties
class Warthog(name: String, age: Int, furColor: String, hasTail: Boolean, val hasTusks: Boolean, diet: DietType) extends Mammal(name, age, furColor, hasTail, diet)

// Owl class extending Bird with additional properties
class Owl(name: String, age: Int, beakLength: Int, featherColor: String, val hootsPerNight: Int, diet: DietType) extends Bird(name, age, beakLength, featherColor, diet)

// Dragonfly class extending Insect with additional properties
class Dragonfly(name: String, age: Int, numOfLimbs: Int, val wingPairs: Int, diet: DietType) extends Insect(name, age, numOfLimbs, diet)

// Trait Species
trait Species {
  val speciesName: String
  val conservationStatus: Boolean
  val avgLifespanRange: Int
  val numOfYoungRange: Int
}

// Trait Flyable
trait Flyable {
  val canFly: Boolean
  val wingSpan: Int
}
//EXTENSION
// Create an Object to represent the sanctuary and add some animals to it
object Sanctuary {

  val owl = new Owl( "coco", 8, 7,"grey",20,Carnivore)
  val warthog = new Warthog("Ricky", 10, "Black", true, true, Herbivore) with DietType {}
  val dragonfly = new Dragonfly("Joey", 1, 6, 2, Carnivore) with Flyable {
    val canFly: Boolean = true
    val wingSpan: Int = 20
  }

}
println(Sanctuary.owl.hootsPerNight)
println(Sanctuary.owl.featherColor)
println(Sanctuary.owl.beakLength)
println(Sanctuary.warthog.hasTusks)
println(Sanctuary.warthog.name)
println(Sanctuary.warthog.age)
println(Sanctuary.warthog.furColor)
println(Sanctuary.warthog.hasTail)
println(Sanctuary.warthog.diet)

println(Sanctuary.dragonfly.canFly)
println(Sanctuary.dragonfly.wingSpan)

// Domesticated class extending Animal with additional properties
class Domesticated(name: String, age: Int, val breed: String, diet: DietType)
  extends Animal(name, age, diet)

// Dog class extending Domesticated with additional properties
class Dog(name: String, age: Int, breed: String, val isTrained: Boolean, diet: DietType)
  extends Domesticated(name, age, breed, diet) with Species {
  val speciesName = "Dog"
  val conservationStatus = true
  val avgLifespanRange = 20
  val numOfYoungRange = 5

}
// Create instances of animals
val Rover: Dog = new Dog("Rover", 8, "Golden Retriever", true, Omnivore)

println(Rover)




