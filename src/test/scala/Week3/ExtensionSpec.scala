package Week3



import Week3.Thur.Extension._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ExtensionSpec extends AnyWordSpec with Matchers {






  "letter" should {
    "be Right(Letter)" in {
      val letter = Right(Letter(Name("Bilal"), Postcode("SE1 1AA")))
      letter shouldEqual Right(Letter(Name("Bilal"), Postcode("SE1 1AA")))
    }
  }

  "invalidLetter" should {
    "be Left(InvalidNameError)" in {
      val invalidLetter = Left(InvalidNameError("Invalid name"))
      invalidLetter shouldEqual Left(InvalidNameError("Invalid name"))
    }
  }


  "Postcode.postcodeOrError" should {
    "return Right if the postcode has a white space inbetween" in {
      Postcode.postcodeOrError("SE1 1AA") shouldEqual Right(Postcode("SE1 1AA"))
    }
    "return Left - InvalidPostcodeError if the postcode doesn't have white space" in {
      Postcode.postcodeOrError("SE11AA") shouldEqual Left(InvalidPostcodeError("Invalid Postcode"))
    }
  }


  "Name.nameOrError" should {
    "return Right if the name is valid" in {
      Name.nameOrError("Bilal Amiry") shouldEqual Right(Name("Bilal Amiry"))
    }
    "return Left - InvalidNameError if the name contains a number" in {
      Name.nameOrError("B1la1 4miry") shouldEqual Left(InvalidNameError("Invalid Name"))
    }
  }

  
  "Letter.letterOrError" should {
    "return Right(Letter) if both name and postcode are valid" in {
      Letter.letterOrError("Bilal Amiry", "SE1 1AA") shouldEqual Right(Letter(Name("Bilal Amiry"), Postcode("SE1 1AA")))
    }
    "return Left(InvalidNameError) if the name is invalid" in {
      Letter.letterOrError("Bilal Amiry1", "SE1 1AA") shouldEqual Left(InvalidNameError("Invalid Name"))
    }
    "return Left(InvalidPostcodeError) if the postcode is invalid" in {
      Letter.letterOrError("Bilal Amiry", "12345") shouldEqual Left(InvalidPostcodeError("Invalid Postcode"))
    }
    "return Left(InvalidNameError) if both name and postcode are invalid" in {
      Letter.letterOrError("Bilal Amiry1", "12345") shouldEqual Left(InvalidNameError("Invalid Name"))
    }
  }


}
