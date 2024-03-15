import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int cents = scanner.nextInt();

            int quarters = cents / 25;
            cents %= 25;

            int dimes = cents / 10;
            cents %= 10;

            int nickels = cents / 5;
            cents %= 5;

            int pennies = cents;

            System.out.println(quarters + " " + dimes + " " + nickels + " " + pennies);
        }
    }
}