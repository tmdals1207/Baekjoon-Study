import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int diagonal = 1;
        int sum = 0;

        while (sum < x) {
            sum += diagonal;
            diagonal++;
        }
        int numerator, denominator;
        if (diagonal % 2 == 0) {
            denominator = x - (sum - diagonal + 1);
            numerator = diagonal - denominator;
        } else {
            numerator = x - (sum - diagonal + 1);
            denominator = diagonal - numerator;            
        }
        System.out.println(numerator + "/" + denominator);
    }
}
