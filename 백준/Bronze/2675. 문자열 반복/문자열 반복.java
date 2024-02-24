import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            String s = scanner.next();

            for (char c : s.toCharArray()) {
                for (int j = 0; j < r; j++) {
                    System.out.print(c);
                }
            }
            
            System.out.println();
        }
    }
}