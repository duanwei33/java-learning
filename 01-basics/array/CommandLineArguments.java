public class CommandLineArguments {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java CommandLineArguments <num1> <num2>");
            return;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println(a + b);
    }
}
