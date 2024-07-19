package Week2.Wed

import org.scalatest.flatspec.AnyFlatSpec

class FizzBuzzSpec extends AnyFlatSpec {

  "fizzBuzz" should "return FizzBuzz if num is divisible by both 3 and 5" in {
    val num = new FizzBuzz
    assert(num.fizzBuzz(15) == "FizzBuzz")
  }

  it should "return Fizz if num is divisible by 3" in {
    val num = new FizzBuzz()
    assert(num.fizzBuzz(9) == "Fizz")
  }

  it should "return Buzz if num is divisible by 5" in {
    val num = new FizzBuzz
    assert(num.fizzBuzz(100) == "Buzz")
    assert(num.fizzBuzz(10) == "Buzz")
  }

}
