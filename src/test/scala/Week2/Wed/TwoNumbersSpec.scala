package Week2.Wed

import org.scalatest.FlatSpec

class TwoNumbersSpec extends FlatSpec {

  "add" should "add number" in{

    val nums = new TwoNumbers(1,2)// new instance of a class
    assert(nums.add == 3)

  }

  "subtract" should " subtract number " in{

    val sub = new TwoNumbers(1,2)
    assert(sub.subtract == -1)

  }

  "multiply" should "multiply number" in {

    val nums = new TwoNumbers(1,2)
    assert(nums.multiply == 2)
  }

  "divide" should " divide numbers" in {

    val nums = new TwoNumbers(2,1)
    assert(nums.divide == 2)
  }

  "isAMultiple" should "number is a multiple" in {
    val nums = new TwoNumbers(10, 5)
    assert(nums.isAMultiple)
  }
  "isntAMultiple" should "number isnt a multiple" in {
    val nums = new TwoNumbers(9, 5)
    assert(!nums.isAMultiple)
  }


}
