import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = row.charAt(j) - '0';
            }
        }

        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    flip(matrixA, i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    System.out.println("-1");
                    scanner.close();
                    return;
                }
            }
        }

        System.out.println(count);
        scanner.close();
    }

    private static void flip(int[][] matrix, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matrix[i][j] = 1 - matrix[i][j];
            }
        }
    }
}