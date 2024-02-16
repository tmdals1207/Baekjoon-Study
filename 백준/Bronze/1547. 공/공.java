import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        
        int ball = 1;

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if (x == ball) {
                ball = y;
            } else if (y == ball) {
                ball = x;
            }
        }
        System.out.println(ball);
    }
}