# 数组

## 遍历数组
### for 循环：需要访问索引时使用。
```
// 遍历数组
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }
}
```
### for-each 循环：代码更简洁，但无法获取索引。
```
// 遍历数组
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }
}

```
### Arrays.toString()：方便打印和查看数组内容。

直接打印数组变量，得到的是数组在JVM中的引用地址：
```
int[] ns = { 1, 1, 2, 3, 5, 8 };
System.out.println(ns); // 类似 [I@7852e922
```
使用Arrays.toString()
```
// 遍历数组
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 1, 2, 3, 5, 8 };
        System.out.println(Arrays.toString(ns));
    }
}
```

## 数组排序
### 常用的排序算法有冒泡排序、插入排序和快速排序等；

### 冒泡排序使用两层for循环实现排序；

### 交换两个变量的值需要借助一个临时变量；

### 可以直接使用Java标准库提供的Arrays.sort()进行排序；
```
// 排序
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
    }
}

```

### 对数组排序会直接修改数组本身。
```
必须注意，对数组排序实际上修改了数组本身。例如，排序前的数组是：

int[] ns = { 9, 3, 6, 5 };
在内存中，这个整型数组表示如下：

      ┌───┬───┬───┬───┐
ns───▶│ 9 │ 3 │ 6 │ 5 │
      └───┴───┴───┴───┘
当我们调用Arrays.sort(ns);后，这个整型数组在内存中变为：

      ┌───┬───┬───┬───┐
ns───▶│ 3 │ 5 │ 6 │ 9 │
      └───┴───┴───┴───┘
即变量ns指向的数组内容已经被改变了。

如果对一个字符串数组进行排序，例如：

String[] ns = { "banana", "apple", "pear" };
排序前，这个数组在内存中表示如下：

                   ┌──────────────────────────────────┐
               ┌───┼──────────────────────┐           │
               │   │                      ▼           ▼
         ┌───┬─┴─┬─┴─┬───┬────────┬───┬───────┬───┬──────┬───┐
ns ─────▶│░░░│░░░│░░░│   │"banana"│   │"apple"│   │"pear"│   │
         └─┬─┴───┴───┴───┴────────┴───┴───────┴───┴──────┴───┘
           │                 ▲
           └─────────────────┘
调用Arrays.sort(ns);排序后，这个数组在内存中表示如下：

                   ┌──────────────────────────────────┐
               ┌───┼──────────┐                       │
               │   │          ▼                       ▼
         ┌───┬─┴─┬─┴─┬───┬────────┬───┬───────┬───┬──────┬───┐
ns ─────▶│░░░│░░░│░░░│   │"banana"│   │"apple"│   │"pear"│   │
         └─┬─┴───┴───┴───┴────────┴───┴───────┴───┴──────┴───┘
           │                              ▲
           └──────────────────────────────┘
原来的3个字符串在内存中均没有任何变化，但是ns数组的每个元素指向变化了。
```

## 二维数组
### 二维数组就是数组的数组，三维数组就是二维数组的数组；

### 多维数组的每个数组元素长度都不要求相同；数组元素的长度
```
        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 }, // 学生甲的语数英成绩
                { 68, 72, 64 }, // 学生乙的语数英成绩
                { 95, 91, 89 }, // ...
                { 67, 52, 60 },
                { 79, 81, 85 },
        };

        int studentCount = scores.length;
        System.out.println("The study number is: " + studentCount);
        int subjectCount = scores[0].length;
        System.out.println("The subject number is: " + subjectCount);
```

### 打印多维数组可以使用Arrays.deepToString()；
```
// 二维数组
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] ns = {
            { 1, 2, 3, 4 },
            { 5, 6 },
            { 7, 8, 9 }
        };
        System.out.println(Arrays.deepToString(ns));
    }
}

```
### 最常见的多维数组是二维数组，访问二维数组的一个元素使用array[row][col]。