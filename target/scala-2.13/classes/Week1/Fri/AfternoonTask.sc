// Define the sealed trait for DietType
sealed trait DietType {
  val eats: String
}

case object Omnivore extends DietType {
  val eats: String = "Plants and Meat"
}
case object Carnivore extends DietType {
  val eats: String = "Meat"
}
case object Herbivore extends DietType {
  val eats: String = "Plants"
}

// Trait Species
trait Species {
  val speciesName: String
  val conservationStatus: String
  val averageLifespanRange: (Double, Double)
  val numberOfYoungRange: (Int, Int)
}

// Trait Flyable
trait Flyable {
  val canFly: Boolean
  val wingSpan: Float
}

// Base class Animal with additional parameter diet
abstract class Animal {
  val name: String
  val age: Float
  val dietType: DietType
}

// Mammal class extending Animal with additional properties
abstract class Mammal extends Animal {
  val furColour: String
  val hasTail: Boolean
}

// Bird class extending Animal with additional properties
abstract class Bird extends Animal {
  val beakLength: Float
  val featherColour: String
}

// Insect class extending Animal with additional properties
abstract class Insect extends Animal {
  val numberOfLimbs: Int
  val antennaeLength: Float
}

// Warthog class extending Mammal with additional properties
class Warthog(
               val name: String,
               val age: Float,
               val furColour: String,
               val hasTail: Boolean
             ) extends Mammal with Species {

  val dietType: DietType = Herbivore
  val hasTusks: Boolean = true
  val speciesName: String = "Warthog"
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7.0, 11.0)
  val numberOfYoungRange: (Int, Int) = (3, 4)
}

// Owl class extending Bird with additional properties
class Owl(
           val name: String,
           val age: Float,
           val beakLength: Float,
           val featherColour: String,
           val wingspan: Float
         ) extends Bird with Species with Flyable {

  val dietType: DietType = Omnivore
  val hootsPerNight: Int = 12
  val speciesName: String = "Owl"
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7, 11)
  val numberOfYoungRange: (Int, Int) = (4, 6)
  val canFly: Boolean = true
  val wingSpan: Float = wingspan
}

// Dragonfly class extending Insect with additional properties
class Dragonfly(

                 val name: String,
                 val age: Float,
                 val numberOfLimbs: Int,
                 val antennaeLength: Float,
                 val wingspan: Float
               ) extends Insect with Species with Flyable {

  val dietType: DietType = Carnivore
  val speciesName: String = "Dragonfly"
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (0.125, 0.167)
  val numberOfYoungRange: (Int, Int) = (24, 200)
  val canFly: Boolean = true
  val wingSpan: Float = wingspan
}

// EXTENSION
// Create an Object to represent the sanctuary and add some animals to it
object Sanctuary {

  def feedAnimal(animal: Animal): Unit = {
    println(s"You fed ${animal.name} some ${animal.dietType.eats}!")
  }

  // Method trying to use `jeffTheDragonfly` before it is initialized
  def dragonflyLifespan(): String = {
    s"The dragonfly's lifespan is ${jeffTheDragonfly.averageLifespanRange}"
  }


  val result = dragonflyLifespan()



  val hedwigTheSnowyOwl = new Owl("Hedwig", 8, 2, "White", 150)
  val pumbaTheWarthog = new Warthog("Pumbaa", 4, "Brown", true)
  val jeffTheDragonfly = new Dragonfly("Jeff", 1, 12, 10, 1)

  def owlHootsPerNight(): Unit = {
    println(s"The owl hoots ${hedwigTheSnowyOwl.hootsPerNight} times per night.")
  }


  feedAnimal(hedwigTheSnowyOwl)
  feedAnimal(pumbaTheWarthog)
  feedAnimal(jeffTheDragonfly)

  owlHootsPerNight()


}


// Domesticated class extending Animal with additional properties
abstract class Domesticated extends Animal {
  val breed: String
}

// Dog class extending Domesticated with additional properties
class Dog(
           private val legal: Boolean,
           val name: String,
           val age: Float,
           val breed: String,
           val isTrained: Boolean,
           val dietType: DietType
         ) extends Domesticated with Species {

  val speciesName: String = "Dog"
  val conservationStatus: String = "Domesticated"
  val averageLifespanRange: (Double, Double) = (10, 15)
  val numberOfYoungRange: (Int, Int) = (1, 10)

  def sit(): String = {
    if (isTrained) {
      s"$name sits."
    } else {
      s"$name is not trained to sit."
    }
  }
  def printDogBreed(): String = {

    s"The dog's breed is ${breed}."
  }// Can access breed directly

}
//println(printDogBreed())
//def printDogBreed(dog: Dog): Unit = {
//
////  println(s"The dog's breed is ${breed}.")
//}// Cant access breed directly

// Create instances of animals
val Rover: Dog = new Dog(true,"Rover", 8, "Golden Retriever", true,  Omnivore)

// Print details of the dog
println(Rover.breed)
println(Rover.speciesName)
println(Rover.conservationStatus)
println(Rover.averageLifespanRange)
println(Rover.numberOfYoungRange)
println(Rover.dietType.eats)
println(Rover.sit())
println(Rover.printDogBreed())

// Method to sit
def sit(rover: String): String = {
  if (Rover.isTrained) {
    s"${Rover.name} sits."
  } else {
    s"${Rover.name} is not trained to sit."
  }
}
println(sit(""))



val owl1 = new Owl("julie",12,1.233f,"blue",20.8f)

def remainingLifespan(age:Int): Double = {
  owl1.averageLifespanRange._2 - age
}
println(remainingLifespan(100))


