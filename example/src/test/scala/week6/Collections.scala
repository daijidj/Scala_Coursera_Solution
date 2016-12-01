package week6

/**
  * Created by ji.dai on 11/17/16.
  */
object Collections {
  def main (args : Array[String]): Unit ={
    val xs = Array(1, 2, 3, 4)
    val ys = xs.map(x => 2 * x)
    println(ys.foreach(print))

    val s = "Hello world"
    val s2 = s.filter(c => c.isUpper)
    println(s2)

    val r  = 1 until 5
    println(s exists(c => c.isUpper)) //true
    println(s forall(c => c.isUpper)) //false
    println(s zip(List(1,2,3))) //Vector((H,1), (e,2), (l,3))
    println(List(1,2,3) zip s) //List((1,H), (2,e), (3,l))
    val pairs = List(1,2,3) zip s
    println(pairs.unzip.toString())//(List(1, 2, 3),List(H, e, l))
    val sFlatMap = s flatMap(c => List('.' , c))
    println(sFlatMap) //.H.e.l.l.o. .w.o.r.l.d
    println(xs.sum)
    println(xs.product)
    println(xs.max)
    println(xs.min)

    //combinations
    def isPrime(n : Int): Boolean = (2 until n) forall(d => n % d != 0)
  }
}
