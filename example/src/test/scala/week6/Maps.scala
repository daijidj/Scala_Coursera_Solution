package week6

/**
  * Created by ji.dai on 11/18/16.
  */
object Maps {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "SwitzerLand" -> "Bern")
  println(capitalOfCountry("US"))
  println(capitalOfCountry("Us"))
}
