package multi.javaimpl;

/**
 * Rational 有理数类
 * 用于熟悉Java的语言特性，特意使用的语言特性上，都加上了注释。
 *
 * Rational 被设计为一个不可变类 Immutable Class, 线程安全
 * 加/减/乘/除等不会就地运算，而是返回新构造的结果
 */

// final class 不可被继承
// 实现 Comparable 接口，可用于排序，作为HashMap的key等
public final class Rational implements Comparable<Rational> {
    // 字段 final，构造后不可变。
    private final int numer;
    private final int denom;

    /**
     * 构造函数
     * 分母不能为0， 否则抛出受检异常
     *
     * @param numerator 分子
     * @param denominator 分母
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("denominator must be non-zero");
        }
        // 确保分母 > 0
        // 分母会进行检查， 调整大于0， 仅允许分子小于0
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), denominator);
        numer = numerator / g;
        denom = denominator / g;
    }

    public Rational(int numerator) {
        this(numerator, 1);
    }

    public Rational() {
        this(0);
    }

    /***
     * Helper functions 返回m和n的最大公约数
     */
    private static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }


    /**
     * 有理数 加法
     * 因为Java无法操作符重载，因此仅能用 foo.add(bar)的形式，不优雅。
     * @param that 被加数
     * @return 新构造的结果有理数
     */
    public Rational add(Rational that) {
        return new Rational(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    public Rational subtract(Rational that) {
        return new Rational(numer * that.denom - denom * that.numer, denom * that.denom);
    }

    public Rational multiply(Rational that) {
        return new Rational(numer * that.numer, denom * that.denom);
    }

    public Rational divide(Rational that) {
        return new Rational(numer * that.denom, denom * that.numer);
    }

    /**
     * 有理数倒数
     * @return 新构造的结果有理数
     */
    public Rational reciprocal() {
        return new Rational(denom, numer);
    }

    /**
     * Override Object类的toString， System.out.println时会调用
     * @return
     */
    @Override
    public String toString() {
        if (denom == 1) {
            return numer + "";
        } else {
            return numer + "/" + denom;
        }
    }

    /**
     * getter 感觉用途不大
     * @return 分子
     */
    public int getNumerator() {
        return numer;
    }

    public int getDenominator() {
        return denom;
    }

    /**
     * 实现 Comparable 接口
     * @param that the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Rational that) {
        return this.numer * that.denom - this.denom * that.numer;
    }

    /**
     * equals 与 hashCode必须同时 Override， 保持相同的返回语义。
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rational that = (Rational) o;
        return numer == that.numer && denom == that.denom;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Test Client 冒烟
     */
    public static void main(String[] args) {
        // 1/2 + 1/6 = 2/3
        {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(1, 6);
            Rational r = r1.add(r2);
            System.out.println(r1 + " + " + r2 + " = " + r );
        }

        // 2/3 - 1/6 = 1/2
        {
            Rational r1 = new Rational(2, 3);
            Rational r2 = new Rational(1, 6);
            Rational r = r1.subtract(r2);
            System.out.println(r1 + " - " + r2 + " = " + r );
        }

        // 1/2 * 2/3 = 1/3
        {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(2, 3);
            Rational r = r1.multiply(r2);
            System.out.println(r1 + " * " + r2 + " = " + r );
        }

        // 1/3 / 2/3 = 1/2
        {
            Rational r1 = new Rational(1, 3);
            Rational r2 = new Rational(2, 3);
            Rational r = r1.divide(r2);
            System.out.println(r1 + " / " + r2 + " = " + r );
        }

    }

}
