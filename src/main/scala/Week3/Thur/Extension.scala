package Week3.Thur

object Extension extends App {



    // 1. Create two case classes, 'Name' and 'Postcode'
    case class Name(value: String)

    case class Postcode(value: String)

    // 2. Create a case class called 'Letter' that contains a 'name' and 'postcode'
    case class Letter(name: Name, postcode: Postcode)

    // 3. Create a trait called 'GenericPostageError'
    trait GenericPostageError {
        val message: String
    }

    // 4. Create a case class called 'InvalidNameError'
    case class InvalidNameError(message: String) extends GenericPostageError

    // 5. Create a case class called 'InvalidPostcodeError'
    case class InvalidPostcodeError(message: String) extends GenericPostageError

    // 6. Create the following variables that have a type
    //'Either[GenericPostageError, Letter]'
    //- val letter : A letter constructed using the 'apply' method of 'Letter'
    //- 'val invalidLetter': An error constructed using the'apply method of
    //"InvalidNameError first
    val letter: Either[GenericPostageError, Letter] = Right(Letter.apply(Name.apply("Bilal"), Postcode.apply("SE1 1AA")))
    val invalidLetter: Either[GenericPostageError, Letter] = Left(InvalidNameError("Invalid name"))

    // 7. Note: Since you defined the value, you can actually refine the above values to be
    //- 'val letter: Right[Nothing, Letter]'
    //- 'val invalidLetter: Left[InvalidNameError, Nothing]'
    //- These are still valid types!
    val letterRefined: Either[Nothing, Letter] = Right(Letter.apply(Name.apply("Bilal"), Postcode.apply("SE1 1AA")))
    val invalidLetterRefined: Either[InvalidNameError, Nothing] = Left(InvalidNameError("Invalid name"))

    // Task 8
    println(letterRefined)
    println(invalidLetterRefined)

    // 9. Create companion object (RESEARCH: what are these, why do we use them?) to PostCode and inside it
    //- Create a method called * postcodeOrError
    //- Pass in a String' called 'maybePostCode'
    //- If the ' maybePostCode ' is two "String's with a whitespace inbetween them, then return a 'Postcode
    object Postcode {
        def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
            if (maybePostCode.trim.split(" ").length != 2) Left(InvalidPostcodeError("Invalid Postcode"))
            else Right(Postcode(maybePostCode))
        }
    }


    // 10. Create companion object to Name' and inside it
    //- Create a method called ' nameOrError'
    //- Use the name from the case class in the method
    //- Pass in a 'String' called ' maybeName'
    //- If the 'name' has a number in it, then return an 'InvalidNameError'
    //- If the above condition is not satisfied, return a 'Name'
    //- The overall return type of this method should be "Either[InvalidNameError, Name'
    object Name {
        def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
            if (maybeName.exists(_.isDigit)) Left(InvalidNameError("Invalid Name"))
            else Right(Name(maybeName))
        }
    }

    // 11. Create companion object to Letter' and inside it
    //- Create a method called ' letterOrError'
    //- Pass in two String's called maybeName' and 'maybePostCode'
    //- In a for comprehension
    //- Use the 'nameOrError and ' letterOrError' to create a ' Letter'
    //- What should the return type
    object Letter {
        def letterOrError(maybeName: String, maybePostCode: String): Either[GenericPostageError, Letter] = {
            for {
                name <- Name.nameOrError(maybeName)
                postcode <- Postcode.postcodeOrError(maybePostCode)
            } yield Letter(name, postcode)
        }
    }

    // 12. Create the following variables in the main method using " letterOrError
    //- 'val letterWithANumberInName*: A letter constructed with a number in the name
    //- 'val letterWithAnInvalidPostcode*: A letter constructed with an invalid postcode
    //(How can we make it invalid)
    //- val letterAllInvalid': A letter constructed with a number in the name and an invalid postcode
    val letterWithANumberInName = Letter.letterOrError("Bilal Amiry1", "SE1 2EA")
    val letterWithAnInvalidPostcode = Letter.letterOrError("Bilal Amiry", "SE12EA")
    val letterAllInvalid = Letter.letterOrError("Jack1 Sparrow", "SE12EA")
    val letterAllValid = Letter.letterOrError("kai bon", "SE14 2DA")

    // 13. Print the values
    println(letterWithANumberInName)
    println(letterWithAnInvalidPostcode)
    println(letterAllInvalid)
    println(letterAllValid)
}
