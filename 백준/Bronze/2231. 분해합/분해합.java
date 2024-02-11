import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean found = false;
        int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int num = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                found = true;
                result = i;
                break;
            }
        }

        if (found) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}