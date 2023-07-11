package multi.scalaimpl

import Rational._

object App {
  def main(args : Array[String]): Unit = {
    // 1/2 + 1/6 = 2/3
    {
      val r1 = new Rational(1, 2)
      val r2 = new Rational(1, 6)
      val r = r1 + r2
      System.out.println(r1 + " + " + r2 + " = " + r)
    }

    // 1/2 + 1 = 3/2
    {
      val r1 = new Rational(1, 2)
      val r2 = 1
      val r = r1 + r2
      System.out.println(r1 + " + " + r2 + " = " + r)
    }

    // 1 + 1/2 = 3/2
    {
      val r1 = 1
      val r2 = new Rational(1, 2)
      val r = r1 + r2
      System.out.println(r1 + " + " + r2 + " = " + r)
    }

  }

}
