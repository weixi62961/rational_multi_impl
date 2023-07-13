from functools import total_ordering


@total_ordering
class Rational:
    def __init__(self, numerator=0, denominator=1):
        assert isinstance(numerator, int)
        assert isinstance(denominator, int)
        assert denominator != 0
        if denominator < 0:
            numerator = -numerator
            denominator = -denominator
        g = Rational.gcd(abs(numerator), denominator)
        self._numerator = numerator // g
        self._denominator = denominator // g

    @staticmethod
    def gcd(n, d):
        if d == 0:
            return n
        else:
            return Rational.gcd(d, n % d)

    def __str__(self):
        if self._denominator == 1:
            return str(self._numerator)
        else:
            return f'{self._numerator}/{self._denominator}'

    def __repr__(self):
        return f'{self.__class__.__name__}({self._numerator}, {self._denominator})'

    def __neg__(self):
        return Rational(-self._numerator, self._denominator)

    def __abs__(self):
        if self._numerator < 0:
            return -self
        return self

    def __add__(self, other):
        if isinstance(other, int):
            other = Rational(other)
        if not isinstance(other, Rational):
            return NotImplemented
        return Rational(self._numerator * other._denominator + self._denominator * other._numerator,
                        self._denominator * other._denominator)

    def __sub__(self, other):
        return self + (-other)

    def __mul__(self, other):
        if isinstance(other, int):
            other = Rational(other)
        if not isinstance(other, Rational):
            return NotImplemented
        return Rational(self._numerator * other._numerator,
                        self._denominator * other._denominator)

    def __truediv__(self, other):
        if isinstance(other, int):
            other = Rational(other)
        if not isinstance(other, Rational):
            return NotImplemented
        return Rational(self._numerator * other._denominator,
                        self._denominator * other._numerator)

    def __radd__(self, other):
        return self + other

    def __rsub__(self, other):
        return (-self) + other

    def __rmul__(self, other):
        return self * other

    def __rtruediv__(self, other):
        return Rational(self._denominator, self._numerator) * other

    # def __iadd__(self, other):
    #     return self.__add__(other)

    def __eq__(self, other):
        if isinstance(other, int):
            other = Rational(other)

        return isinstance(other,
                          Rational) and self._numerator == other._numerator and self._denominator == other._denominator

    def __hash__(self):
        return hash((self._numerator, self._denominator))

    def __bool__(self):
        return self._numerator != 0

    def __lt__(self, other):
        if isinstance(other, int):
            other = Rational(other)
        if not isinstance(other, Rational):
            return NotImplemented

        return self._numerator * other._denominator - self._denominator * other._numerator < 0


if __name__ == '__main__':
    r1 = Rational(1, 2)
    r2 = Rational(1, 6)
    r = r1 + r2
    print(r1, '+', r2, '=', r)
    r = r + 1
    print(r)
    r = 1 + r
    print(r)
    r += 1
    print(r)
