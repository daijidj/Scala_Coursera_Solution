package week3

/**
  * Created by ji.dai on 11/2/16.
  */
object intsets extends App{
  val t1 = new NonEmpty(3,  Empty,  Empty)

  val t2 = t1 include 4
  val t3 = t1 include  4
  println("t2: " + t2)
  println("t1: " + t1)
  println(t2.contains(5))
}

abstract class IntSet{
  def include(x : Int) : IntSet
  def contains(x : Int) : Boolean
  def union(other : IntSet) : IntSet
}

object Empty extends IntSet {
  def include(x : Int) : IntSet = new NonEmpty(x, Empty, Empty)
  def contains(x : Int) :Boolean = false
  def union(other: IntSet) = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def include(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left include x, right)
    else if (x > elem) new NonEmpty(elem, left, right include x)
    else this
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  override def union(other : IntSet): IntSet ={
    ((left union right) union other) include elem
  }
  override def toString = "{" + left + elem + right + "}"
}


