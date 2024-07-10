package Week2.Wed

class FizzBuzz {
  def fizzBuzz(num: Int): String = {
    if (num % 3 == 0 && num % 5 == 0) {
      "FizzBuzz"
    } else if (num % 3 == 0) {
      "Fizz"
    } else if (num % 5 == 0) {
      "Buzz"
    } else {
      "404"
    }
  }

}
