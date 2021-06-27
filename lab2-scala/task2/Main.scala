class KontoBankowe(start: Double) {
  def this() {
    this(0);
  }
  private var _stanKonta: Double = start;

  def stanKonta: Double = _stanKonta;

  def wplata(wplacane: Double): Unit = {
    _stanKonta = wplacane + _stanKonta;
    println("Po wpłacie " + wplacane + "PLN " + " masz: " + _stanKonta);
  }

  def wyplata(wyplacane: Double): Unit = {
    if(_stanKonta>=wyplacane) {
      _stanKonta = _stanKonta - wyplacane;
      println("Po wypłacie " + wyplacane + "PLN " + " masz: " + _stanKonta);
    }
    else println("Nie ma tyle. Przemysl to na spokojnie.")
  }
}

object zadanie2 {
  def main(args: Array[String]): Unit = {
    val kontoBankowe = new KontoBankowe(10000);
    kontoBankowe.wplata(10000);
    kontoBankowe.wyplata(200);
    kontoBankowe.wyplata(5000);
    kontoBankowe.wyplata(500000);
  }
}