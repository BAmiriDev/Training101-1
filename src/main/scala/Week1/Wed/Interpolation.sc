//s

val name: String = "April"
println(s"My name is $name")

println(s"3x3 = ${3*3}")

val number: Int = 7
println(s"$number x $number = ${number*number}")

//f

// %f = floating point number
// %d - decimal
// %i - int

val pi: Double = 3.1415926535897
println(f"Pi to 2dp is $pi%.2f")
println(f"Pi to 4dp is $pi%.4f")
println(f"Pi to 2dp but with 16 width is  $pi%26.6f")

println("hello \nworld")

printf("'%s", "hello")
printf("'%s'", name)
printf("'%16s'", name)
printf("'%-16s'", name)

//RAW
println(raw"hello \nworld")

//a)
val a: String = "tom"
val b: String = "max"

println(s"$a is older than $b")
//b)
val age1: Double = 20
val age2: Double = 25

println(s"$a is ${age2-age1} years older than $b")
//c)
val newage1: Double = 20.534
val newage2: Double = 25.2345

println(f"$a is older ${newage1 - newage2}%.2f years older")


//d)
println(raw"\n\n\n\n\n\\n\n\n\nsameline\n\n\n")


val height:Double = 1.6
println(f"$a is $height%.2f kg over weight")
printf("%s is %.3f kg over weight", a, height)
