import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.next();
        int b = scanner.nextInt();

        int gap = 0;
        int power = 1;

        for (int i = n.length() - 1; i >= 0; i--) {
            int digit;
            char c = n.charAt(i);
            if (Character.isDigit(c)) {
                digit = c - '0';
            } else {
                digit = c - 'A' + 10;
            }
            gap += digit * power;
            power *= b;
        }
        System.out.println(gap);
    }
}
