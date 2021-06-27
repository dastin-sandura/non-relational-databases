
object zd4 {
  def tripletta(number: Int, fx: Int => Int): Int = {
    fx(fx(fx(number)));
  }

  def main(args: Array[String]): Unit = {
    val num = 2;
    val fx = (x:Int) => x*2;
    println(tripletta(num, fx));
  }
}
