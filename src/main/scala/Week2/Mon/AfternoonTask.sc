//The Fibonacci sequence is a series of numbers where each number is the sum of the two numbers before it
//2. Write pure function(s) to return the Fibonacci sequence
val seqSize = 5
def Fibonacci(seq: Seq[Int] ): Seq[Int] = {
  if (seq.length >= seqSize) {
    seq
  } else {
    Fibonacci(seq :+ (seq(seq.length - 1) + seq(seq.length - 2)))
  }
}
println(Fibonacci(Seq(3,4)))
//3)do the same, but with an impure function. Which is better? Why?
var seqSize = 9
def FibonacciImpure(seq: Seq[Int] ): Seq[Int] = {
  if (seq.length >= seqSize) {
    seq
  } else {
    FibonacciImpure(seq :+ (seq(seq.length - 1) + seq(seq.length - 2)))
  }
}
seqSize = 7
println(FibonacciImpure(Seq(3,4)))


//4) Create a method that calls the pure Fibonacci sequence function, giving it a default value for “n”.



def defaultVal(n: Int = 4): Seq[Int] = {
  seqSize = n
  FibonacciImpure(Seq(3, 4))
}

// Example usage:
println(defaultVal())  // Output: Seq(3, 4, 7, 11, 18, 29, 47, 76, 123, 199)

//EXTENSION
//1.convert the sequence into a string? Write the code for this in infix. (Research infix.)
// Generate the sequence
val result = FibonacciImpure(Seq(3, 4))
println(result.mkString(", "))

