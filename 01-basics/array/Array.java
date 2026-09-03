import java.util.Arrays;

public class Array {

    public static void main(String[] args) {

        int[] ns = { 1, 4, 9, 16, 25 };

        // 1. Traverse array using a standard for loop
        System.out.println("=== Standard for Loop ===");
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }

        // 2. Traverse array using a for-each loop
        System.out.println("\n=== For-Each Loop ===");
        for (int n : ns) {
            System.out.println(n);
        }

        // 3. Print the array using Arrays.toString()
        System.out.println("\n=== Arrays.toString() ===");
        System.out.println(Arrays.toString(ns));

        // 4. Traverse the array in reverse order
        System.out.println("\n=== Reverse Traversal ===");
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.println(ns[i]);
        }
    }
}