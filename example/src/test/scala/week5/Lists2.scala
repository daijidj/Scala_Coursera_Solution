package week5

/**
  * Created by ji.dai on 11/16/16.
  */
object Lists2 {
  def main(args : Array[String]) : Unit = {
    val list = List(1, 2, 3)
    squareList1(list).foreach(println)
    squareList2(list).foreach(println)
    println(list.filter(x => x > 0).toString())
    println(list.filterNot(x => x > 0).toString())
    println(list.partition(x => x > 0).toString())
    println(list.takeWhile(x => x > 0).toString())
    println(list.dropWhile(x => x > 0).toString())
    println(list.span(x => x > 0).toString())
    val data = List("a","a","a","b", "c","c", "a")
    encode(data)
  }
  def squareList1(xs : List[Int]) : List[Int] = xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList1(ys)
  }

  def squareList2(xs : List[Int]) : List[Int] = xs.map(x => x * x )

  def pack[T] (xs : List[T]) : List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs.span(y => y == x)
      first :: pack(rest)
  }

  /*def encode [T](xs : List[T]) : List[(T, Int)] = xs match{
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs.span(y => y == x)
      (x , first.length):: encode(rest)
  }*/

  def encode [T](xs : List[T]) : List[(T, Int)] = {
    pack(xs).map(ys => (ys.head, ys.length))
  }
}
