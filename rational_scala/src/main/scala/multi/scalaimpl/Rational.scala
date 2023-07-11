package multi.scalaimpl

import scala.annotation.tailrec
import scala.language.implicitConversions

// 设计为一个不可变对象的类
// Scala中，类可以直接接收参数。n, d 是类参数，类定义体内可以直接使用类参数。
// 类定义体中的代码（除字段和方法外），作为类的主构造方法
// 实现特质 Trait Ordered, 用于排序
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  // 定义前置条件 precondition： d必须非0，否则抛出 IllegalArgumentException
  require(d != 0, "denominator must be non-zero")
  // 此处临时用到的最大公约数，也定义为字段。似乎不妥。
  private val g = gcd(n.abs, d.abs)
  // 定义分子分母字段
  private val numer: Int = (if (d < 0) -n else n) / g
  private val denom: Int = d.abs / g

  // 辅助构造方法 auxiliary constructor
  def this(n: Int) = this(n, 1)
  def this() = this(0, 1)

  // override覆盖 java.lang.Object类的toString方法
  override def toString: String =
    if (denom == 1) numer.toString else s"$numer/$denom"

  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  @tailrec
  private def gcd(m: Int, n: Int): Int =
    if (n == 0) m else gcd(n, m % n)

  override def equals(other: Any): Boolean =
    other match {
      case that: Rational => (that canEqual this) && numer == that.numer && denom == that.denom
      case _ => false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[Rational]

  override def hashCode(): Int = (numer, denom).##

  override def compare(that: Rational): Int =
    (this.numer * that.denom) - (that.numer * this.denom)
}

object Rational {
  implicit def intToRational(x: Int): Rational = new Rational(x)

}