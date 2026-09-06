// 引用类型参数绑定（String）
// 结论：String 不可变，bob = "Alice" 是让变量指向新对象，并没有修改原对象，所以 p.name 仍是 "Bob"
public class StringParamBinding {
    public static void main(String[] args) {
        PersonWithName p = new PersonWithName();
        String bob = "Bob";
        p.setName(bob); // 传入bob变量
        System.out.println(p.getName()); // "Bob"
        bob = "Alice"; // bob改名为Alice
        System.out.println(p.getName()); // "Bob"还是"Alice"? -> "Bob"

        if (p.getName().equals("Bob")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}

class PersonWithName {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
