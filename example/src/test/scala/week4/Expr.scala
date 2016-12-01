package week4

/**
  * Created by ji.dai on 11/8/16.
  */
trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
  def show(e : Expr) : String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
  }
}

case class Number(n :Int) extends Expr{
  // eval : Int = n
}

case class Sum (e1 : Expr, e2 : Expr) extends Expr{
  //override def eval: Int = e1.eval + e2.eval
}

object Number {
  def apply(n: Int): Number = new Number(n)
}

object Sum {
  def apply(e1: Expr, e2: Expr): Sum = new Sum(e1, e2)
}