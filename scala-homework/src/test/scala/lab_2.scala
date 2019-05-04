object lab_2 extends App{

  case class Film( name: String,
                   yearOfRelease: Int,
                   imdbRating: Double)
  case class Director( firstName: String,
                       lastName: String,
                       yearOfBirth: Int,
                       films: Seq[Film])


  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))
  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())
  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

  //task - 1
  def directed(numberOfFilms : Int): Seq[Director] ={
    val temp = for {
      i <- directors
      if i.films.length > numberOfFilms
    } yield i

    temp
  }
  val new_directors = directed(4)

  //task-2

  def before(year: Int, directors: Seq[Director] = directors): Seq[Director] ={
    val temp = for {
      i <- directors
      if i.yearOfBirth > year
    } yield i

    temp
  }

  //task-3

  def mixDirectedAndBefore(year: Int,numberOfFilms: Int): Seq[Director] ={
    val afterDirected = directed(numberOfFilms)
    val afterDirectedAndBefore = before(year,afterDirected)
    afterDirectedAndBefore
  }

  //task-4
  def ascendingSort(): Seq[Director] ={
    directors.sortWith(_.yearOfBirth < _.yearOfBirth)
  }

  def descendingSort(): Seq[Director] ={
    directors.sortWith(_.yearOfBirth > _.yearOfBirth)
  }

  def sortedDirectors(ascending: Boolean = true) : Seq[Director] ={
    ascending match {
      case true => ascendingSort()
      case false=> descendingSort()
    }
  }

  //task-5

  def nolanFilms(): Seq[String] ={
    val temp = for {
      i <- directors
      if i.firstName == "Christopher" && i.lastName == "Nolan"
      film <- i.films
    } yield film.name
    temp
  }


  //task-6

  def allFilms(): Seq[String] ={
    val temp = for {
      i <- directors
      film <- i.films
    } yield film.name
    temp
  }

  //task-7

  def earlyMc(): Int ={
   val films = mcTiernan.films
    val temp = for {
      i <- films

    } yield i.yearOfRelease

    temp.sorted
    temp.head
  }


  //task-8
  def sortImdb(): Seq[Film] ={
    val temp = for {
      i <- directors
      film <- i.films
    } yield film

    temp.sortWith(_.imdbRating < _.imdbRating)
    temp
  }

  //task-9

  def avScore(): Double ={

    var total = 0.0
    var count = 0
    directors.foreach(
      director=>director.films.foreach(
        film=> {
          total+=film.imdbRating

          count+=1}
      )
    )
    total/count
  }

  //task-10

  def toNight():Unit ={
    print(123)
    directors.foreach(
      director=>director.films.foreach(
        film=> {
          val name = film.name
          val dir = director.firstName + " " + director.lastName
          println(s"Tonight only! $name by $dir")
        }

      )
    )
  }
  //task-11

  def archives(): Film ={
    val temp = for {
      i <- directors
      film <- i.films
    } yield film

    temp.sortWith(_.yearOfRelease < _.yearOfRelease)
    temp.head
  }



}
