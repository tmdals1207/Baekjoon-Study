import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int time = 0;
        int bird = 1;

        while (n > 0) {
            if (bird > n) {
                bird = 1;
            }
            n -= bird;
            bird++;
            time++;
        }

        System.out.println(time);
    }
}