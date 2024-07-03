val weather: String = "warm"
val season: String = "winter"

//if (weather == "cold" && season== "winter") {
//  println(s"It is $weather" + "! take a coat.")
//} else {
//  println("dont take a coat")
//}

if (weather == "cold") {
  println("take a coat")

}  else if(weather == "rain"){
  println("take an umbrella")
}else {
  println(s"$weather is an error")
}


val percentage: Int = 120

if (percentage >= 90 && percentage <= 100) {
  println("A")
} else if (percentage >= 80) {
  println("B")
} else if (percentage >= 70) {
  println("C")
} else if (percentage >= 60) {
  println("D")
} else if (percentage >= 50) {
  println("E")
} else if (percentage < 50) {
  println("F")
} else {
  println("invalid")
}

val agelimit: Int = 12
val filmrating: String = "_"

if(agelimit <= 4 ){
  println("U")
}
