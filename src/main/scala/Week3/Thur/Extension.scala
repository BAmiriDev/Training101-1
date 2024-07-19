package Week3.Thur

object Extension extends App{





    // 1. Create two case classes, 'Name' and 'Postcode'
    //- Both can take "value:
    case class Name(value: String)
    case class Postcode(value: String)

    // 2. Create a case class called Letter' that contains a 'name' and
    //"postcode
    //- The name' should have the type 'Name'
    //- The 'postcode should have the type'Postcode'
    case class Letter(name: Name, postcode: Postcode)

    // 3. Create a trait called 'GenericPostageError'
    //- Give it a parameter method message' with a type "String'
    trait GenericPostageError {
      val message: String
    }

    //4. Create a case class called 'InvalidNameError'
    //- Give it a parameter message' with a type "String'
    //- Let it be extended by
    case class InvalidNameError(message: String) extends GenericPostageError

    // 5. Create a case class called 'Invalid PostcodeError'
    //- Give it a parameter 'message' with a type "String'
    //- Let it be extended by 'GenericPostageError'
    case class InvalidPostcodeError(message: String) extends GenericPostageError

    // 6. Create the following variables that have a type 'Either[GenericPostageError, Letter]'
    // - val letter : A letter constructed using the '.apply' method of 'Letter'
    // - val invalidLetter : An error constructed using the '.apply' method of 'InvalidNameError' first
    val letter: Either[GenericPostageError, Letter] = Right(Letter.apply(Name.apply("Bilal"), Postcode.apply("se1")))
    val invalidLetter: Either[GenericPostageError, Letter] = Left(InvalidNameError.apply("invalid name"))

    // 7. Note: Since you defined the value, you can actually refine the above values to be
    //- ' val letter: Right[Nothing, Letter]'
    //- val invalidLetter: Left[InvalidNameError, Nothing}
    //- These are still valid
    val Letter1: Either[Nothing, Letter] = Right(Letter.apply(Name.apply("Bilal"), Postcode.apply("se1")))
    val invalidLetter1: Either[InvalidNameError, Nothing] = Left(InvalidNameError.apply("Name is invalid"))

    // Task 8
    println(Letter1)
    println(invalidLetter1)

    // 9. Create companion object (RESEARCH: what are these, why do we use them?) to PostCode and inside it
    //Companion objects can access the private members, methods of their corresponding class
    //- Create a method called * postcodeOrError
    //- Pass in a String' called 'maybePostCode'
    //- If the ' maybePostCode ' is two "String's with a whitespace inbetween them, then return a 'Postcode
    //- If the above condition is not satisfied, return an 'InvalidPostcodeError'
    //- The overall return type of this method should be Either[InvalidPostcodeError,
    object Postcode {
      def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
//        if (maybePostCode) Right(Postcode(maybePostCode))
//        else Left(InvalidPostcodeError("Invalid Postcode"))
      }
    }

    // 10. Create companion object to Name' and inside it
    //- Create a method called ' nameOrError'
    //- Use the name from the case class in the method
    //- Pass in a 'String' called ' maybeName'
    //- If the 'name' has a number in it, then return an 'InvalidNameError'
    //- If the above condition is not satisfied, return a 'Name'
    //- The overall return type of this method should be "Either[InvalidNameError, Namel'
    object Name {
      def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
        //if ()
      }
    }




}


