package week5

import scala.collection.immutable.::

/**
  * Created by ji.dai on 11/8/16.
  */
object Lists {
  def main (args : Array[String]) : Unit = {
    val nums = List(4,3,1,2)
    println(msort(nums)(Ordering.Int).toString())
  }
  val nums = 1 :: (2 :: (3 :: ( 4 :: Nil)))
  def insert(x : Int, xs : List[Int]): List[Int] = xs match{
    case List() => List(x)
    case y :: ys  => if(x <= y) x :: xs else y :: insert(x, ys)
  }
  def isort(xs : List[Int]) : List[Int] = xs match {
    case List() => List()
    case y :: ys => insert (y, isort(ys))
  }
  def init[T] (xs : List[T]) : List[T] = xs match {
    case List() => throw new Error("init of emoty")
    case List(x) => Nil
    case y :: ys => y :: init(ys)
  }
  def concat[T] (xs : List[T], ys: List[T]) : List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }
  def reverse[T] (xs : List[T]) : List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }
  def removeAt[T](n: Int, xs: List[T]) :List[T] = xs.take(n) ::: xs.drop(n + 1)

  def flatten[T](xs: List[T]): List[T] = ???

  //MERGE SORT
  def msort[T] (xs : List[T])(implicit ord : Ordering[T]) : List[T] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs : List[T], ys : List[T]) : List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if(ord.lt(x, y)) x :: merge (xs1, ys)
            else y :: merge (xs, ys1)
        }
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  /*def msort[T] (xs : List[T])(lt : (T , T) => Boolean) : List[T] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs : List[T], ys : List[T]) : List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if(lt(x, y)) x :: merge (xs1, ys)
            else y :: merge (xs, ys1)
        }
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }*/
  /*def merge (xs : List[Int], ys : List[Int]) : List[Int]= {
    xs match {
      case Nil => ys
      case x :: xs1 =>
        ys match {
          case Nil => xs
          case y :: ys1 =>
            if(x < y) x :: merge(xs1, ys )
            else y :: merge(xs, ys1)
        }
    }
  }*/

}
