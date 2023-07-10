# Rational 有理数类 Java 实现
## 1. 整体设计决策
- Rational 被设计为一个不可变类 Immutable Class, 线程安全
- Rational 被设计为final，不可被继承
- 加/减/乘/除等不会就地运算，而是返回新构造的结果
### 构造函数
- Java构造函数支持重载，其它两个构造函数调用第一个构造函数来实现代码复用。
### 加减乘除
- Java不支持操作符重载，只能定义成员方法 add/subtract/multiply/divide, 不优雅
### 转为字符串
- 覆盖 Object 类的 toString 方法
### 相等性判断
- Java中 == 操作符会比较对象引用，而非对象内容。
- 对象内容比较，需要覆盖 Object类的 equals 方法与 hashCode 方法
### 排序及大小比较
- 实现 Comparable<T> 接口中， CompareTo 方法。用于集合或Map Key的比较排序。

## 2. 客户端调用样例
```java
// 1/2 + 1/6 = 2/3
Rational r1 = new Rational(1, 2);
Rational r2 = new Rational(1, 6);
Rational r = r1.add(r2);
System.out.println(r1 + " + " + r2 + " = " + r );
```