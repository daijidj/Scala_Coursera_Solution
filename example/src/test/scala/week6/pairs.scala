package week6

/**
  * Created by ji.dai on 11/17/16.
  */
object pairs {
  val n = 7
  def isPrime(n : Int): Boolean = (2 until n) forall(d => n % d != 0)
  val pairs = (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

  //scalar product
  def scalarProduct(xs : List[Double], ys : List[Double]):Double = {
    (for((x, y) <- xs zip ys ) yield x * y).sum
  }

}
