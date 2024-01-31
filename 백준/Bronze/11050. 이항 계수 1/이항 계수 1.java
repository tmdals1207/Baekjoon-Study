import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int value = Factorial(n) / (Factorial(k) * (Factorial(n - k)));
        System.out.println(value);
    }

    public static int Factorial(int x) {
        int result = 1;
        for (int i = x; i > 0; i--) {
            result *= i;
        }
        return result;
    }

}