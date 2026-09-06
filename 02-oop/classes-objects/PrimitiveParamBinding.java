// 基本类型参数绑定
// 结论：基本类型参数传递的是值的拷贝，setAge(n) 之后修改 n 不会影响 p 内部的 age
public class PrimitiveParamBinding {
    public static void main(String[] args) {
        PersonWithAge p = new PersonWithAge();
        int n = 15; // n的值为15
        p.setAge(n); // 传入n的值
        System.out.println(p.getAge()); // 15
        n = 20; // n的值改为20
        System.out.println(p.getAge()); // 15还是20? -> 15

        if (p.getAge() == 15) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}

class PersonWithAge {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
