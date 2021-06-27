class Osoba(val _imie : String, val _nazwisko: String, val _podatek: Double) {
  def imie: String = _imie;
  def nazwisko: String = _nazwisko;
  def podatek: Double = _podatek;
}

trait Pracownik extends Osoba{
  var pensja : Double;
  override def podatek: Double = 0.2
}

trait Nauczyciel extends Pracownik {
  override def podatek = 0.1;
}

trait Student extends Osoba {
  override def podatek: Double = 0.0
}

object zd5 {

  def main(args: Array[String]) : Unit = {
    val pracownik = new Osoba(
      "Bingo",
      "Gonzales",
      0.4) with Pracownik {
      var pensja = 6500;
    }

    val student = new Osoba("Banjo",
      "Gonzales", 0.4) with Student

    val studentPracownik = new Osoba("Bonjo",
      "Trembales", 0.4) with Student with Pracownik{
      var pensja = 7500;
    };

    val pracownikStudent = new Osoba("Bonjo",
      "Gonzales", 0.4) with Pracownik with Student{
      var pensja = 8500;
    };

    val nauczyciel = new Osoba("Benjo",
      "Tamales", 0.4) with Nauczyciel{
      var pensja = 9500;
    }

    println(pracownik.podatek);
    println(student.podatek);
    println(studentPracownik.podatek);
    println(pracownikStudent.podatek);
    println(nauczyciel.podatek);
  };
}


