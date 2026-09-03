import java.util.Arrays;

public class SortDescending {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        System.out.println("Before sorting: " + Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - 1 - i; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
                // System.out.println(Arrays.toString(ns));
            }
        }

        System.out.println("After sorting: " + Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[8, 12, 18, 28, 36, 50, 65, 73, 89, 96]")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}