package Week3
import Week3.Thur.ForComp._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ForCompSpec extends AnyWordSpec with Matchers {

  "retrieveNumbers" should{
    val expected = Seq(1,2,3,4,5,6,7,8,9,10)

    "generate a seq of number from 1 to 10" in{
     retriveNumbers shouldBe expected
    }
  }

  "contains 10 elements" in {
    retriveNumbers should have length 10
  }
  "start with 1 and end with 10" in {
    retriveNumbers.head shouldBe 1
    retriveNumbers.last shouldBe 10
  }


}
