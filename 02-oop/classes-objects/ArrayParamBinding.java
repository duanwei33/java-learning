// 引用类型参数绑定（数组）
// 结论：数组参数传递的是引用，p.name 和 fullname 指向同一个数组，修改数组元素会互相影响
public class ArrayParamBinding {
    public static void main(String[] args) {
        PersonWithFullName p = new PersonWithFullName();
        String[] fullname = new String[] { "Homer", "Simpson" };
        p.setName(fullname); // 传入fullname数组
        System.out.println(p.getName()); // "Homer Simpson"
        fullname[0] = "Bart"; // fullname数组的第一个元素修改为"Bart"
        System.out.println(p.getName()); // "Homer Simpson"还是"Bart Simpson"? -> "Bart Simpson"

        if (p.getName().equals("Bart Simpson")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}

class PersonWithFullName {
    private String[] name;

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }
}
