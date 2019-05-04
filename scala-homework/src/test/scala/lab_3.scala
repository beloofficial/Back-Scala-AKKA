object lab_3 extends App{

  //task-1
  def divide(first: Int,second: Int): Option[Int] ={
    if (second == 0) None
    else Some(first/second)
  }

  //task-2

  def readInt(str: String): Option[Int] =
    if(str matches "\\d+") Some(str.toInt) else None


  def sumOfOptionsUsingFor(opt1: Option[Int], opt2: Option[Int],op :Option[String]): Option[Int] = {
    var o1 = opt1.get
    var o2 = opt2.get
    var oper = op.get
    oper match {
      case "+"=> Some(o1+o2)
      case "-"=> Some(o1-o2)
      case "*"=> Some(o1*o2)
      case "/"=> divide(o1,o2)
      case _ => None
    }
  }

  def calc(first: String, second:String,operand: String): Unit ={

    val q = readInt(first).flatMap {
      res1 =>
        readInt(second).flatMap {
          res2 =>
            sumOfOptionsUsingFor(Option(res1), Option(res2), Option(operand))
        }
    }


  print(q.getOrElse(throw new java.lang.NumberFormatException))

  }
  calc("4","9","*")
}
