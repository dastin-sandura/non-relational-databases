object zd1 {
  def matchWeekDays(x: String): String = x match {
    case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
  def main(args: Array[String]): Unit = {
    println(matchWeekDays("Poniedziałek"));
    println(matchWeekDays("Wtorek"));
    println(matchWeekDays("Sobota"));
    println(matchWeekDays("Jutro"));
  }
}
