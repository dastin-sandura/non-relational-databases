case class Osoba (imie: String, nazwisko: String) {
}

object zd3 {
  def displayWelcomeMessage(o: Osoba){
    val textToDisplay = o match {
      case Osoba("Bingo", _) => s"Hola, ${o.imie}"
      case Osoba("Banjo", _) => s"Comesta, ${o.imie}"
      case Osoba("Bonjo", _) => s"Bien, ${o.imie}"
      case default => s"Hello, ${o.imie}"
    }
    println(textToDisplay)
  }

  def main(args: Array[String]): Unit = {
    val peopleList: List[Osoba] = List(
      new Osoba("Bingo","Gonzales"),
      new Osoba("Banjo","Morales"),
      new Osoba("Bonjo", "Korales"),
      new Osoba("Gringo", "Tamales")
    )
    peopleList.foreach(o => displayWelcomeMessage(o));
  }
}
