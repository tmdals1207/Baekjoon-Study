import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int result = calculate(a, b);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int calculate(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int lastDigit = 1;
        for (int j = 0; j < b; j++) {
            lastDigit = (lastDigit * a) % 10;
        }

        return (lastDigit == 0) ? 10 : lastDigit;
    }
}
