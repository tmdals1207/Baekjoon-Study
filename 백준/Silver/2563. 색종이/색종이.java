import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[][] board = new boolean[100][100];

        int total = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!board[j][k]) {
                        board[j][k] = true;
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}