package week4

import week3._

/**
  * Created by ji.dai on 11/4/16.
  */
//peano numbers

object List{
  //List(1,2) = List.apply(1,2)
  def apply[T]() = new Nil
  def apply[T](x1 : T) : List[T] = new Cons[T](x1, new Nil)
  def apply[T](x1 : T, x2 : T): List[T] = new Cons(x1, new Cons(x2, new Nil))
}
trait List[+T] {
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
  def prepend [U >: T](elem : U) : List[U] = new Cons(elem, this)
  //def f(xs: List[NonEmpty] , x: Empty) = xs prepend x
}

class Cons[T] (val head : T, val tail : List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def head: T = throw new NoSuchElementException("Nil.head")
  override def tail: T = throw new NoSuchElementException("Nil.tail")
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat{
  override def isZero: Boolean = true
  override def predecessor: Nat = throw new Error("0.predecessor")


  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if(that.isZero) this else throw new Error("Negative number")
}

class Succ(n: Nat) extends Nat{
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor
}