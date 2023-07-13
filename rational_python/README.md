# Rational 有理数类 Python 实现

## 1. 整体设计决策
- Python标准库中有fractions.Fraction类，本例子中Rational为简化版。仅仅为了说明Python特性。
### 构造函数
- 函数支持默认参数，无需像Java一样重载。
### 加减乘除
- 实现 __add__, __sub__, __mul__, __div__ 等魔术方法(dunder)即可支持加减乘除运算符。
### 转为字符串
- 实现 __repr__ 魔术方法
### 相等性判断
- 实现 __repr__ 魔术方法
- 实现 __hash__ 魔术方法
### 排序及大小比较
- 使用装饰器 @total_ordering， 仅需要实现 __eq__ 以及任选一个大小于方法即可。 本例子选择 __lt__

## 2. 客户端调用样例
```python
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
```

## 参考资料
- [Python 库 fractions — Rational numbers](https://docs.python.org/3.9/library/fractions.html)
- [The Rational Class](https://anh.cs.luc.edu/170/mynotes/rational.html)
- [Rational](https://anh.cs.luc.edu/170/examples/rational.py)

