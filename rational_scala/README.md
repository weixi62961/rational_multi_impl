# Rational 有理数类 Scala 实现
## 1. 整体设计决策
- Rational 被设计为一个不可变类 Immutable Class, 线程安全
- 加/减/乘/除等不会就地运算，而是返回新构造的结果
### 构造函数
- Scala 主构造函数在类体中。
- 还支持通过 def this() 来实现辅助构造方法。
### 加减乘除
- Scala支持操作符重载，或者说，+-等操作符，对于Scala仅仅是普通的标识符，定义普通的方法而已。
### 转为字符串
- 覆盖 Object 类的 toString 方法
### 相等性判断
- 与Java不同， Scala中 == 操作符，会进行相等性判断。
### 排序及大小比较
- 实现 Ordered特质， 重载compare方法。

### 伴生对象
- 这是Scala的特色，相当于一个单例对象。与类定义在一个文件中，可以承载一些静态字段或静态方法。
- 本例中实现了隐式转换

## 2. 客户端调用样例
```Scala
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

```


## 参考资料
- 《Scala编程》第4版
- [Functional Rationals in Scala](https://www.jasonfilippou.com/blog/functional-rationals)