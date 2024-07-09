import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            int[] result = fibonacci(N);
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }

    private static int[] fibonacci(int n) {
        int[] count = new int[2];
        int[][] fib = new int[n + 1][2];

        fib[0][0] = 1;
        fib[0][1] = 0;
        if (n > 0) {
            fib[1][0] = 0;
            fib[1][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            fib[i][0] = fib[i - 1][0] + fib[i - 2][0];
            fib[i][1] = fib[i - 1][1] + fib[i - 2][1];
        }

        count[0] = fib[n][0];
        count[1] = fib[n][1];

        return count;
    }
}