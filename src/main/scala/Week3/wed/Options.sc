trait Pizza {
  val size: Int
  val crust: Option[String]
}

object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None
}

object smallClasic extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("classic")
}

val pizzaOrder: Pizza = new Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("italian")
}

def whatCrust(pizza: Pizza): String = {
  pizza.crust match {
    case Some("classic") => "classic crust"
    case Some("italian") => "italian crust"
    case Some(x) => s"$x is not a valid crust type"
    case None => "default crust - classic "
  }
}

whatCrust(pizzaOrder)

// .get
val getCrust:String = pizzaOrder.crust.get //bad practice

// . getOrElse (default to be given)
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("classic")

case class ChocolateBar(filling: Option[String])

def filling(chocolateBar: ChocolateBar): String = {
  chocolateBar.filling.getOrElse("just chocolate")

}



object choc1 extends ChocolateBar(Some("caramel"))
object choc2 extends ChocolateBar(Some("ccream"))
object choc3 extends ChocolateBar(None)



filling(choc1)
filling(choc2)
filling(choc3)


