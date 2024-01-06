import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int plus = scanner.nextInt();
        int minus = scanner.nextInt();
        int height = scanner.nextInt();
        int day_height = 0;
        day_height = (plus - minus);
        System.out.println((height - minus - 1) / day_height + 1);
        scanner.close();
    }
}
