object lab_1 extends App {

  //task-1-cats

  class Cat(Name: String, Colour: String, Food: String)

  var cat1 = new Cat("Oswald", "Black", "Milk")

  var cat2 = new Cat("Henderson", "Ginger", "Chips")

  var cat3 = new Cat("Quentin", "Tabby and white", "Curry")

  //task-2

  class Director(_firstName: String, _LastName: String, _yearOfBirth: Int) {

    def firstName = _firstName
    def LastName = _firstName
    def yearOfBirth = _yearOfBirth
    def name(): String = firstName + LastName

  }
  class Film(Name: String, yearOfRelease: Int, imdbRating: Double, _director: Director) {
    def copy(name: String = "Amantay", yearOfRelease: Int = 1999, imdbRating: Double = 10.0, director: Director = eastwood):Film = {
      new Film(name,yearOfRelease,imdbRating,director)
    }


    def director = _director
    def directorsAge(): Int = yearOfRelease - director.yearOfBirth

    def isDirectedBy(dir: Director): Boolean = dir == director
  }


  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "SomeBody", 1990)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("DarkKnight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("HighPlainsDrifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("TheOutlawJoseyWales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("GranTorino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("DieHard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("TheHuntforRedOctober", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("TheThomasCrownAffair", 1999, 6.8, mcTiernan)


  println(eastwood.yearOfBirth) //should be 1930
  println(dieHard.director.name) //should be "JohnMcTiernan"
  println(invictus.isDirectedBy(nolan)) // should be false

  highPlainsDrifter.copy(name ="L'hommedeshautesplaines") // returns Film("L'hommedeshautesplaines",1973,7.7,/*etc*/)
  thomasCrownAffair.copy(yearOfRelease = 1968,director = new Director("Norman","Jewison", 1926)) // returnsFilm("TheThomasCrownAffair",1926,/*etc*/)
  inception.copy().copy().copy() // returns a new copy of`inception`

  //task-3

  class Counter(cou: Int){
    def inc: Counter={
      new Counter(cou+1)
    }
    def dec: Counter={
      new Counter(cou-1)
    }
    def count: Int={
      cou
    }
  }
  println(new Counter(10).inc.dec.inc.inc.count)

  //task-4

  class Counter2(cou: Int){
    def inc(inc: Int = 1): Counter2={
      new Counter2(cou+inc)
    }
    def dec(dec: Int = 1): Counter2={
      new Counter2(cou-dec)
    }
    def count: Int={
      cou
    }
  }
  println(new Counter2(10).inc(2).dec().inc(2).inc(2).count)

  //task-5
  case class Cat2(Name: String, Colour: String, Food: String)

  var cat4 = Cat2("Alibi","brown","Chips")
  //task-6

  case class Director2(firstName: String, LastName: String, yearOfBirth: Int) {

    def name(): String = firstName + LastName

  }

  case class Film2(Name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
    def copy(name: String = "Amantay", yearOfRelease: Int = 1999, imdbRating: Double = 10.0, director: Director = eastwood):Film = {
      new Film(name,yearOfRelease,imdbRating,director)
    }
    def directorsAge(): Int = yearOfRelease - director.yearOfBirth

    def isDirectedBy(dir: Director): Boolean = dir == director
  }

  //task-7
  class Counter3(cou: Int = 0){
    def inc(inc: Int = 1): Counter2={
      new Counter2(cou+inc)
    }
    def dec(dec: Int = 1): Counter2={
      new Counter2(cou-dec)
    }
    def count: Int={
      cou
    }
  }

  //task-8

  object ChipShop{
    def willServe(cat: Cat2): Boolean ={
      cat match {
        case Cat2(a,b,c) if c == "Chips"=>true
        case _ =>false
      }
    }
  }
  print(ChipShop.willServe(cat4))

  object Dad{
    def rate(film: Film2): Double ={
      film match {
        case Film2(a,b,c,d) if d.name() == "Clint Eastwood"=>10.0
        case Film2(a,b,c,d) if d.name() == "John McTiernan"=>7.0
        case _ =>3.0
      }
    }
  }
}