import scala.annotation.tailrec

object Main extends App {
  val weekDays = List("Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
  println(weekDays)

  /**
   * * Zadanie 1
   * Stwórz 7 elementową listę zawierającą nazwy dni tygodnia.
   * Napisz funkcję tworzącą w oparciu o nią stringa
   * z elementami oddzielonymi przecinkami korzystając z:
   * a. Pętli for
   * b. Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
   * c. Pętli while
   *
   * @param list
   */
  println("Zadanie 1")

  def zadanie1a(list: List[String]) : String = {
    var res = "";
    //Skladanie stringa a potem printowanie wyniku
    for (i <- 0 until list.size) res += (list(i) + " ")
    return res;
  }
  println(" Wszystkie for:  " + zadanie1a(weekDays))

  def zadanie1b(list: List[String]):String= {
    var res = "";
    for (i <- 0 until list.size) {
      if (list(i).startsWith("P")) {
        res +=(list(i) + " ")
      }
    }
    return res;
  }
  println(" Zaczynające się na p: " + zadanie1b(weekDays))


  def zadanie1c(list: List[String]):String = {
    var res= "";
    var i = 0
    while (i < list.size) {
      res+= (list(i) + " ")
      i += 1
    }
    return res;
  }

  println(" Wszystkie while" + zadanie1c(weekDays))

  println("Zadanie2")

  /**
   * * Zadanie 2
   * Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa
   * z elementami oddzielonymi przecinkami korzystając z:
   * a. Funkcji rekurencyjnej
   * b. Funkcji rekurencyjnej wypisując elementy listy od końca
   */

  def recursionHeadToTail(lista: List[String]): String = {
    if (lista.size == 0) {
      return ""
    } else {
      return lista.head + " " + recursionHeadToTail(lista.slice(1, (lista.size)))
    }
  }

  def recursionTailToHead(lista: List[String]): String = {
    if (lista.size == 0) {
      return ""
    } else {
      return recursionTailToHead(lista.tail) + lista.head + " "
    }
  }

  println("Recursion head to tail")
  println(recursionHeadToTail(weekDays))

  println("Reqcursion tail to head")
  println(recursionTailToHead(weekDays))

  /** Zadanie 3
   * Stwórz funkcję korzystającą z rekurencji ogonowej
   * do zwrócenia oddzielonego przecinkami stringa zawierającego elementy listy z ćwiczenia 1
   */

  println("Zadanie 3")

  @tailrec
  def tailRec(index: Int = 0, resultString: StringBuilder = new StringBuilder): String = {
    resultString.append((weekDays(index)) + ",");
    if (index >= weekDays.length - 1) {
      resultString.deleteCharAt(resultString.length() - 1);
      return resultString.toString();
    }
    tailRec(index + 1, resultString);
  }

  println("Zadanie 3" + tailRec())
// a b c
//   b c
//    c -> return lista.head
//  b c return lista.head
//  a b c return lista.head

  //println(tailRecursion(weekDays))
  /**
   * Zadanie 4
   * Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa
   * z elementami oddzielonymi przecinkami korzystając z:
   * a. Metody foldl
   * b. Metody foldr
   * c. Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”
   */
  println("Zadanie 4")
  var resFoldfLeft = "";
  var fLeft = weekDays.foldLeft() { (z, i) => {
    resFoldfLeft += i + ", "
  }}
  println("Wynik fold left: " + resFoldfLeft)

  var resFoldfRigh = "";
  weekDays.foldRight() { (z,i) => {
    resFoldfRigh += z + ", "
  }}
  println("Wynik fold right: " + resFoldfRigh)

  var resFoldfLeftP = "";
  weekDays.foldLeft() { (z,i) => {
    if(i.startsWith("P"))
      resFoldfLeftP += i + ", "
  }}
  println("Wynik fold left zaczynających na P: " + resFoldfLeftP)

/**
 * Zadanie 5
 * Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen. Wykorzystaj mechanizm mapowania kolekcji.
 **/

val products = Map("Maslo" -> 5.50, "Banan" -> 5.40, "Kasza" -> 10.10, "Bulka" -> 3.80);
def mapPriceIncrease(elo: Map[String,Double]): Map[String, Double] = {
  return elo.map(pair=>(pair._1, pair._2*1.1));
};
println("Zadanie 5")
println("Przed podwyzka" + products)
println("Po podwyzka" + mapPriceIncrease(products))
/**
 * Zadanie 6
 * Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je
 **/
def tuplePrint(t: (Int, String, Double)) = {
  println(t._1 + " " +  t._2 + " " + t._3);
}
  println("Zadanie 6");
  tuplePrint(1, "2", 3.4);
/**
 * Zadanie 7
 * Zaprezentuj działanie Option na dowolnym przykładzie
 * (np. mapy, w której wyszukujemy wartości po kluczu)
 **/

  var some = products.get("Maslo");
  var none = products.get("test");
  println(some); //zwrca wynik opakowany w Some zamiast bezposredniego wyniku
  println(none);

  /**
 * Zadanie 8
 * Napisz funkcję usuwającą zera z listy wartości całkowitych
 * (tzn. zwracającą listę elementów mających wartości różne od 0). Wykorzystaj rekurencję.
 **/
val numbers: List[Int] = List(1,0,2,3,0,4,5,6,7,8,9,0);

  def removeZeros(valueToBeRemoved: Int, inputNumbers: List[Int]): List[Int]= inputNumbers match {
    case Nil => Nil
    case head :: tail =>
      if(head == valueToBeRemoved)
        removeZeros(0,tail)
      else
        head :: removeZeros(0, tail);
  }
  println("Zadanie 8 " + removeZeros(0, numbers))
/**
 * Zadanie 9
 * Zdefiniuj funkcję, przyjmującą listę liczb całkowitych i
 * zwracającą wygenerowaną na jej podstawie listę,
 * w której wszystkie liczby zostały zwiększone o 1.
 * Wykorzystaj mechanizm mapowania kolekcji.\
 **/

val listOfIntegers= List(1,2,3);

  def increaseByOne(list: List[Int]): List[Int] = {
    return list.map(_+1);
  }
  println("Zadanie 9 " + increaseByOne(listOfIntegers));
/**
 * Zadanie 10
 * Stwórz funkcję przyjmującą listę liczb rzeczywistych
 * i zwracającą stworzoną na jej podstawie listę
 * zawierającą wartości bezwzględne elementów z
 * oryginalnej listy należących do przedziału <-5,12>. Wykorzystaj filtrowanie
 */

val listOfRealNumbers = List(-6, -5, 0, 1, 2.2, 3, 24);

  def absolutRange(list: List[Double]): List[Double] = {
    val ranged = list.filter(n => n >= -5 && n <= 12);
    return  ranged.map(math.abs);
  }
  println("Zadanie 10" + absolutRange(listOfRealNumbers));
}