import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int F = scanner.nextInt();

        for (int i = N / 100 * 100; i < (N / 100 + 1) * 100; i++) {
            if (i % F == 0) {
                int answer = i % 100;
                if (answer < 10) {
                    System.out.println("0" + answer);
                } else {
                    System.out.println(answer);
                }
                break;
            }
        }
    }
}
