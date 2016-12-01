package week3

/**
  * Created by ji.dai on 11/2/16.
  */
object overrides extends App{
  val sub = new Sub
  println(sub.a)
}
abstract class Base{
  def foo = 1
  def bar :Int
  var a = 1
}
class Sub extends Base{
  override def foo = 2
  def bar = 1
  override val a = 2
}