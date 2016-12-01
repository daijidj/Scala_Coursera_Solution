package week2

/**
  * Created by ji.dai on 10/27/16.
  */
object exercise_product {
  def main(args: Array[String]): Unit = {

    println(product(square)(3,4))
  }

  def square(x : Int) = x * x

  //factorial in terms of product
  def factorial (n : Int): Int ={
    product(x => x)(1, n)
  }
  def product(f:Int => Int)(a:Int, b:Int) : Int = {
    if(a > b){
      1
    }else{
      f(a) * product(f)(a + 1, b)
    }
  }

}
