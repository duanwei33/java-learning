# 类与对象

## class和instance
在OOP中，class和instance是“模版”和“实例”的关系；
定义class就是定义了一种数据类型，对应的instance是这种数据类型的实例；
class定义的field，在每个instance都会拥有各自的field，且互不干扰；
通过new操作符创建新的instance，然后用变量指向它，即可通过变量来引用这个instance；
访问实例字段的方法是变量名.字段名；
指向instance的变量都是引用变量。

## 方法

    方法可以让外部代码安全地访问实例字段；
    方法是一组执行语句，并且可以执行任意逻辑；
    方法内部遇到return时返回，void表示不返回任何值（注意和返回null不同）；
    外部代码通过public方法操作实例，内部代码可以调用private方法；
    理解方法的参数绑定。



## 参数绑定

### Java 只有值传递：调用方法时永远是把「变量里的值」复制一份给形参，不存在引用传递。

基本类型和引用类型的区别不在传递方式，而在于被复制的那个值是什么：

- 基本类型：变量里装的是**数据本身**，复制的是数据。
- 引用类型：变量里装的是**对象的地址**，复制的是地址。

### 真正的分水岭是「改变量」还是「改对象」，而不是「基本类型」还是「引用类型」。

| 操作 | 基本类型 | 引用类型 |
| --- | --- | --- |
| 给变量重新赋值 | 外部不可见 | 外部不可见 |
| 通过引用修改对象内部状态 | 不可能 | 外部可见 |

## 基本类型参数绑定

### 传递的是值的拷贝，之后修改外部变量不会影响对象内部。

对应 `PrimitiveParamBinding.java`：

```java
PersonWithAge p = new PersonWithAge();
int n = 15;
p.setAge(n);   // 把 15 复制给形参 age，再 this.age = age 存进对象
n = 20;        // 只改 main 里的 n
System.out.println(p.getAge()); // 15
```

```
调用 p.setAge(n)，复制的是数据本身：

      main 的 n              setAge 的 age
      ┌────┐                 ┌────┐
      │ 15 │  ─── 复制 ───▶  │ 15 │
      └────┘                 └────┘
                                │
               this.age = age   ▼
      p ──▶ PersonWithAge { age: 15 }

n = 20 之后，两者已是两块独立内存：

      main 的 n              p ──▶ PersonWithAge { age: 15 }
      ┌────┐                              ↑
      │ 20 │                            不变
      └────┘
```

## 引用类型参数绑定

### 传递的是对象的地址，实参和形参指向同一个对象，因此修改对象内部状态会互相影响。

对应 `ArrayParamBinding.java`：

```java
PersonWithFullName p = new PersonWithFullName();
String[] fullname = new String[] { "Homer", "Simpson" };
p.setName(fullname);   // this.name = name，复制的是地址
fullname[0] = "Bart";  // 改的是数组对象里的元素，不是改变量
System.out.println(p.getName()); // "Bart Simpson"
```

```
调用 p.setName(fullname) 之后，两个引用指向同一个数组：

      fullname ──▶ ┌─────────┬───────────┐
                   │ "Homer" │ "Simpson" │
                   └─────────┴───────────┘
                        ▲
      p.name ───────────┘

fullname[0] = "Bart" 改的是数组对象，两个引用都看得到：

      fullname ──▶ ┌────────┬───────────┐
      p.name ─────▶│ "Bart" │ "Simpson" │
                   └────────┴───────────┘
      → p.getName() == "Bart Simpson"
```

### 给引用类型的变量重新赋值，对外部同样不可见——这一点和基本类型完全一致。

对应 `StringParamBinding.java`：

```java
PersonWithName p = new PersonWithName();
String bob = "Bob";
p.setName(bob);        // this.name = name，复制的是地址
bob = "Alice";         // 重新赋值
System.out.println(p.getName()); // "Bob"
```

```
调用 p.setName(bob) 之后，两个变量指向同一个 String：

      bob ─────┐
               ├──▶ "Bob"
      p.name ──┘

bob = "Alice" 是让 bob 指向新对象，并没有动 "Bob"：

      bob ────────▶ "Alice"
      p.name ─────▶ "Bob"          ← 不变
      → p.getName() == "Bob"
```

### String 这个例子结果是「不变」，但它有两个独立的原因，别只记一个。

1. `bob = "Alice"` 是**给变量重新赋值**，不是修改对象。换成任何可变对象（数组、`StringBuilder`）重新赋值，结果都一样——对外不可见。
2. String **不可变**，所以「通过引用修改对象内容」这条路根本走不通。

### String 看起来像基本类型，就是因为同时满足上面两点。

想看到引用类型的「真面目」，把 String 换成 `StringBuilder` 并调用 `append()`（修改对象而不是重新赋值），修改就会对外可见。

### 记忆：Java 永远复制变量里的东西——基本类型复制数据（改谁都不影响对方），引用类型复制地址（改对象会互相看见，改变量不会）。


## 构造方法
实例在创建时通过new操作符会调用其对应的构造方法，构造方法用于初始化实例；
没有定义构造方法时，编译器会自动创建一个默认的无参数构造方法；
可以定义多个构造方法，编译器根据参数自动判断；
可以在一个构造方法内部调用另一个构造方法，便于代码复用。