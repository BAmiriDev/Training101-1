package Week3

import Week3.Thur.MVP
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MVPSpec extends AnyWordSpec with Matchers {

  "validateCreditScore" should {
    "return Right with the credit score if it is >= 550" in {
      assert(MVP.validateCreditScore(600) == Right(600))
    }
    "return Left with an error message if the credit score is < 550" in {
      assert(MVP.validateCreditScore(500) == Left("Credit score is too low ."))
    }
  }

  "mortgageAmount" should {
    "return the correct mortgage amount based on salary" in {
      assert(MVP.mortgageAmount(45000) == 180000)
      assert(MVP.mortgageAmount(20000) == 80000)
    }
  }

  "validateDeposit" should {
    "return Right with the deposit if it is >= 10% of the purchase price" in {
      assert(MVP.validateDeposit(28000, 280000) == Right(28000))
    }
    "return Left with an error message if the deposit is < 10% of the purchase price" in {
      assert(MVP.validateDeposit(20000, 280000) == Left(" less than 10% of the house price."))
    }
  }

  "canPurchaseFlat" should {
    "return Right with a success message if the mortgage and deposit are sufficient to purchase the flat" in {
      val samantha = MVP.Samantha(deposit = 100000)
      //assert(MVP.canPurchaseFlat(samantha)
    }
    "return Left with an error message if the mortgage and deposit are not enough to purchase the flat" in {
      ???

    }
  }



}

