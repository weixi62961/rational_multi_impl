package multi.scalaimpl

import org.junit.Test
import org.junit.Assert._

class RationalSuite {

  @Test
  def testConstructor(): Unit = {
    val r = new Rational(1, 2)
    assertEquals("1/2", r.toString)
  }

  @Test(expected = classOf[IllegalArgumentException])
  def testConstructorException(): Unit = {
    new Rational(1, 0)
  }

  @Test
  def testAuxConstructor(): Unit = {
    val r1 = new Rational(5)
    assertEquals("5", r1.toString)

    val r2 = new Rational()
    assertEquals("0", r2.toString)
  }

  @Test
  def testArithmetic(): Unit = {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(1, 3)

    assertEquals(new Rational(5, 6), r1 + r2)
    assertEquals(new Rational(1, 6), r1 - r2)
    assertEquals(new Rational(1, 6), r1 * r2)
    assertEquals(new Rational(3, 2), r1 / r2)
  }

  @Test
  def testEquality(): Unit = {
    assertEquals(new Rational(2, 4), new Rational(1, 2))
    assertNotEquals(new Rational(1, 2), new Rational(2, 3))
  }

}
