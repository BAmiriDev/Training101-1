package Week2.Wed

import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {



  "fizzBuzz" should "if numb is divisible by both 3 and 5, will return FizzBuzz" in {
    val num = new FizzBuzz
    assert(num.fizzBuzz(15) == "FizzBuzz")
  }

  "fizzBuzz" should "if num is divisible by 3 will return Fizz" in {
    val num = new FizzBuzz()
    assert(num.fizzBuzz(9) == "Fizz")
  }

  "fizzBuzz" should "if num is divisible by 5" in {
    val num = new FizzBuzz
    assert(num.fizzBuzz(100) == "Buzz")
  }


}
