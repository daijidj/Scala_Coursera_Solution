object exercise1{
  def product(f : Int => Int) (a : Int, b :Int) = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero : Int)(a : Int, b :Int): Int ={
    if(a > b) zero
    else{
      combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    }
  }
  def factorial(n:Int) = product(x => x)(1, n)
  factorial(5)
  product(x => x)(3,4)

  //
  val tolerance = 0.0001
  def isCloseEnough(x : Double, y : Double) = math.abs((x - y) / x) / x < tolerance
  def fixedPoint(f : Double => Double)(firstGuess : Double) = {
    def iterate (guess : Double) : Double = {
      println("guess: " + guess)
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  def averageDamp(f: Double => Double)(x:Double) = (x + f(x)) / 2
  fixedPoint(x => 1 + x/2)(0)
  def squareRoot(x : Double) = fixedPoint(averageDamp(y => x/y))(1)
  squareRoot(4)
}