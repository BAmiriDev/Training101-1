package Week3.Thur

case object MVP extends App {
  case class Samantha(salary: Double = 45000, creditScore: Int = 577, deposit: Double = 20000, purchasePrice: Double = 280000)

  def validateCreditScore(creditScore: Int): Either[String, Int] = {
    if (creditScore < 550) Left("Credit score is too low .")
    else Right(creditScore)
  }

  def mortgageAmount(salary: Double): Double = {
    salary * 4
  }

  def validateDeposit(deposit: Double, purchasePrice: Double): Either[String, Double] = {
    if (deposit < purchasePrice / 10) Left(" less than 10% of the house price.")
    else Right(deposit)
  }

  def validateMortgageEligibility(samantha: Samantha): Either[String, Double] = {
    for {
      validCreditScore <- validateCreditScore(samantha.creditScore)
      validDeposit <- validateDeposit(samantha.deposit, samantha.purchasePrice)
      mortgage = mortgageAmount(samantha.salary)
    } yield mortgage
  }

  def canPurchaseFlat(samantha: Samantha): Either[String, String] = {
    if ((mortgageAmount(samantha.salary) + samantha.deposit) < samantha.purchasePrice) Left("The mortgage + deposit is not enough.")
    else Right("can purchase desired house")
  }

  val samantha = Samantha()

  println(validateCreditScore(samantha.creditScore))
  println(validateDeposit(samantha.deposit, samantha.purchasePrice))
  println(canPurchaseFlat(samantha))
  println(validateMortgageEligibility(samantha))

}


