import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        while (t > 0) {
            String input = scanner.nextLine();
            System.out.println(validation(input) ? "YES" : "NO");
            t--;
        }
    }

    private static boolean validation(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) {
                return false; 
            }
        }

        return count == 0; 
    }
}