import unittest

from rational.rational import Rational


class TestRational(unittest.TestCase):

    def test_init(self):
        r = Rational(1, 2)
        self.assertEqual(r._numerator, 1)
        self.assertEqual(r._denominator, 2)

        r = Rational(2, -4)
        self.assertEqual(r._numerator, -1)
        self.assertEqual(r._denominator, 2)

        with self.assertRaises(AssertionError):
            Rational(1.5, 2)

        with self.assertRaises(AssertionError):
            Rational(1, 0)

    def test_gcd(self):
        self.assertEqual(Rational.gcd(2, 4), 2)
        self.assertEqual(Rational.gcd(15, 20), 5)

    def test_str(self):
        r = Rational(3, 6)
        self.assertEqual(str(r), '1/2')

        r = Rational(5, 1)
        self.assertEqual(str(r), '5')

    def test_repr(self):
        r = Rational(3, 8)
        self.assertEqual(repr(r), 'Rational(3, 8)')

    def test_neg(self):
        r = Rational(-3, 4)
        self.assertEqual(str(-r), '3/4')

    def test_abs(self):
        r = Rational(-3, 4)
        self.assertEqual(str(abs(r)), '3/4')

    def test_add(self):
        r1 = Rational(1, 2)
        r2 = Rational(1, 3)
        r = r1 + r2
        self.assertEqual(str(r), '5/6')

        r = r1 + 1
        self.assertEqual(str(r), '3/2')

    def test_sub(self):
        r1 = Rational(3, 4)
        r2 = Rational(1, 2)
        r = r1 - r2
        self.assertEqual(str(r), '1/4')

    def test_mul(self):
        r1 = Rational(1, 2)
        r2 = Rational(2, 3)
        r = r1 * r2
        self.assertEqual(str(r), '1/3')

        r = r1 * 3
        self.assertEqual(str(r), '3/2')

    def test_div(self):
        r1 = Rational(1, 2)
        r2 = Rational(2, 3)
        r = r1 / r2
        self.assertEqual(str(r), '3/4')

    def test_comparison(self):
        r1 = Rational(1, 2)
        r2 = Rational(2, 4)
        self.assertTrue(r1 == r2)
        self.assertFalse(r1 != r2)
        self.assertTrue(r1 <= r2)
        self.assertTrue(r1 >= r2)

        r3 = Rational(3, 4)
        self.assertTrue(r1 < r3)
        self.assertFalse(r1 > r3)

    def test_bool(self):
        r1 = Rational(3, 5)
        r2 = Rational(0, 7)
        self.assertTrue(bool(r1))
        self.assertFalse(bool(r2))

    def test_math_ops(self):
        r = Rational(1, 2)
        self.assertEqual(2 + r, Rational(5, 2))
        self.assertEqual(2 - r, Rational(3, 2))
        self.assertEqual(2 * r, 1)
        self.assertEqual(2 / r, 4)


if __name__ == '__main__':
    unittest.main()
