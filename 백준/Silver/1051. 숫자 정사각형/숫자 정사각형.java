import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < M; j++) {
                square[i][j] = row.charAt(j) - '0';
            }
        }

        int maxSize = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int size = 1; size < Math.min(N, M); size++) {
                    if (i + size < N && j + size < M) {
                        if (square[i][j] == square[i][j + size] &&
                            square[i][j] == square[i + size][j] &&
                            square[i][j] == square[i + size][j + size]) {
                            maxSize = Math.max(maxSize, (size + 1) * (size + 1));
                        }
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
