/** Case Classes */

// Extra methods:
//- an apply method
// unapply methjod
//hashcode and equals methods
//copy method
// toString method

case class SupperHero(realName: String, heroName: String, weekness: String )
//apply method
//use tto make objects
val newSuperHero = SupperHero.apply("clark kent", "superman ", "kryptonite")
//OR Write it out
//dont need to use the keyword "new"
val anothernewSuperHero = SupperHero("clark kent", "superman ", "kryptonite")

// ==
newSuperHero == anothernewSuperHero
//compares what make the objects - the parameters. not the name of the object

//copy method
val updateName = anothernewSuperHero.copy(realName = "clark lane")

// Dog case class
case class Dog(name: String, breed: String, age: Int)
// Create some dog objects
val dog1 = Dog("Isac", "Bully", 11)
val dog2 = Dog("issy", "Labrador", 7)
val dog3 = Dog("Rocky", "Pit bull", 9)
val dog4 = Dog("Chump", "Bulldog", 5)
// Cat case class
case class Cat(name: String, color: String, age: Int)
// Create some cat and bird objects
val cat1 = Cat("Garfield", "ShortHair", 6)
val cat2 = Cat("isabel", "WildCat", 5)
// Bird case class
case class Bird(name: String, species: String, age: Int)
val bird1 = Bird("billy", "Canary", 2)
val bird2 = Bird("Pollo", "Parrot", 3)

// Kennel case class with lists for dogs, cats, and birds
case class Kennel(name: String, dogs: List[Dog], cats: List[Cat], birds: List[Bird])

// List of dogs,cats,birds
val dogList = List(dog1, dog2, dog3, dog4)
val catList = List(cat1,cat2)
val birdList = List(bird1, bird2)

// Create a new kennel object and add dogs
val kennel = Kennel("Animal List", dogList, catList, birdList)


// Change the kennel's name using the copy method
val newKennel = kennel.copy("Best Pets 2024")
//Add new animal
val addDog = newKennel.copy("List with extra Dog",dogList :+ Dog("Buddy", "Beagle", 4))

println(addDog)



/** Case Objects*/
case object Hulk
Hulk.getClass
case object SuperMan
