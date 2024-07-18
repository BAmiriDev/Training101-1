val weather: String = "Cold"

if (weather == "cold") {
  println("take a coat")
} else if (weather == "rain") {
  println("take an umbrella")
} else {
  println(s"$weather is an error")
}

weather.toLowerCase match {
  case "cold" => println("take a coat")
  case "rain" => println("take an umbrella")
  case _ => println(s"$weather is not valid")
}

//Match off int
val numOfWatermrlons: Int = 3
numOfWatermrlons match {
  case x if x <= 0 => println("Must be more than zero")
  case 1 | 2 | 3 => println("John can carry these without a bag")
  case 4 | 5 => println("john needs a bag.")
  case _ => println(s"$numOfWatermrlons is invalid")
}

// if guard - be careful of ordering

//matching off objects
sealed trait Temperature //can only be extended within the same file that is defined in
object Cold extends Temperature
object Hot extends Temperature
object Mild extends Temperature

val weather: Temperature = Cold

weather match {
  case Cold => "take a coat"
  case Hot => "wear sun cream"
  case Mild => "Light jacket"
  case _ => "not valid"
}


//Match using classes

abstract class Notification //Cannot be instantiated - must be extended
case class Email (sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String ) extends Notification
case class voiceRecording(contactName: String, link: String) extends Notification

val notification: Notification = SMS("Mum", "Are you home")

notification match {
  case Email(sender, title, body) => "Email from " + sender + "title: " + title
  case SMS(caller, message) if caller == "mum" => "SMS from." + caller + " don't ignore."
  case SMS(caller, message) => "sms from " + caller
  case voiceRecording(contactName, link) => "recording from " + contactName + "with link: " + link
  case _ => "not valid"
}

val flavour: String = "spicy"

flavour match{
  case "veggie" => "margaretta"
  case "spicy" => "american hot"
  case "meaty" => "pepperoni"
  case _ => "unknown flavour"
}

val pizzaSize: Int = 11

pizzaSize match {
  case 7 => "Personal"
  case 9 => "Small"
  case 11 => "medium"
  case 14 => "Large"
  case _ => "invalid size"
}

case class Pizza(price: String, crust: String)
Pizza match {
  case "personal" + "classic" => 5.99
  case "small" + "classic, italian" => 6.99

}


//val pizza: Pizza = ""
