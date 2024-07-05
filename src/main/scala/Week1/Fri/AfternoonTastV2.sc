// MVP
// Base class Animal with common properties name and age
class Animal(val name: String, val age: Int)

// Mammal class extending Animal with additional properties
class Mammal(name: String, age: Int, val furColor: String, val hasTail: Boolean) extends Animal(name, age)

// Bird class extending Animal with additional properties
class Bird(name: String, age: Int, val beakLength: Int, val featherColor: String) extends Animal(name, age)

// Insect class extending Animal with additional properties
class Insect(name: String, age: Int, val numOfLimbs: Int) extends Animal(name, age)

// Warthog class extending Mammal with additional properties
class Warthog(name: String, age: Int, furColor: String, hasTail: Boolean, val hasTusks: Boolean) extends Mammal(name, age, furColor, hasTail)

// Owl class extending Bird with additional properties
class Owl(name: String, age: Int, beakLength: Int, featherColor: String, val hootsPerNight: Int) extends Bird(name, age, beakLength, featherColor)

// Dragonfly class extending Insect with additional properties
class Dragonfly(name: String, age: Int, numOfLimbs: Int, val wingPairs: Int) extends Insect(name, age, numOfLimbs)

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

// EXTENSION
// Define the sealed trait for DietType
sealed trait DietType
case object Herbivore extends DietType
case object Carnivore extends DietType
case object Omnivore extends DietType
val owl = new Owl("Coco", 8, 7, "Grey", 20) with DietType {
  val feedAnimal = Herbivore
}
// Create an Object to represent the sanctuary and add some animals to it
object Sanctuary {
  val owl = new Owl("Coco", 8, 7, "Grey", 20) {
    val diet: DietType = Carnivore
  }

  val warthog = new Warthog("Ricky", 10, "Black", true, true) with Species {
    val speciesName: String = "Pig"
    val conservationStatus: Boolean = true
    val avgLifespanRange: Int = 12
    val numOfYoungRange: Int = 3
    val diet: DietType = Herbivore
  }

  val dragonfly = new Dragonfly("Joey", 1, 6, 2) with Flyable {
    override val canFly: Boolean = true
    override val wingSpan: Int = 20
    val diet: DietType = Carnivore
  }
///error///
  // Domesticated class extending Animal with additional properties
  class Domesticated(name: String, age: Int, val breed: String) extends Animal(name, age)

  // Dog class extending Domesticated with additional properties
  class Dog(name: String, age: Int, breed: String, val isTrained: Boolean) extends Domesticated(name, age, breed) with Species {
    val speciesName = "Dog"
    val conservationStatus = true
    val avgLifespanRange = 20
    val numOfYoungRange = 5
    val diet: DietType = Omnivore
  }

  // Create an instance of Dog
  val Rover = new Dog("Rover", 8, "Golden Retriever", true)




}