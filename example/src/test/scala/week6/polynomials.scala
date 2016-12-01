package week6

/**
  * Created by ji.dai on 11/18/16.
  */
object polynomials {
  def main(args : Array[String]): Unit ={
    val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
    val p2 = new Poly(0 -> 3.0 , 3 -> 7.0)
    val p3 = p1 + p2
    //p1.terms(7)
    println(p3)
  }

  //version 1
  /*class Poly(terms0 : Map[Int, Double]){
    val terms = terms0 withDefaultValue(0.0)
    def this (bindings: (Int,Double)*) = this (bindings.toMap)
    def + (other : Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term : (Int, Double)) : (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))//右边的map会自动覆盖左边的map，所以在这边直接对右边的map赋值
    }
    override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString "+"
  }*/

  //version 2
  class Poly(terms0 : Map[Int, Double]){
    val terms = terms0 withDefaultValue(0.0)
    def this (bindings: (Int,Double)*) = this (bindings.toMap)
    def + (other : Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms : Map[Int, Double], term : (Int, Double)) : Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))//右边的map会自动覆盖左边的map，所以在这边直接对右边的map赋值
    }
    override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString "+"
  }

}
