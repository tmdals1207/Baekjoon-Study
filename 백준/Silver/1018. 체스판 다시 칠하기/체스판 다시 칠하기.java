import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int min = 64;

        char[][] board = new char[x][y];

        for (int i = 0; i < x; i++) {
            String row = scanner.next();
            for (int j = 0; j < y; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; x - i >= 8; i++) {
            for (int j = 0; y - j >= 8; j++) {
                int check = countRepaint(board, i, j);
                min = Math.min(min, Math.min(check, 64 - check));
            }
        }
        System.out.println(min);
    }

    private static int countRepaint(char[][] board, int startRow, int startCol) {
        int repaintCount = 0;

        char repaintColor = board[startRow][startCol];

        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if (board[i][j] != repaintColor) {
                    repaintCount++;
                }
                repaintColor = (repaintColor == 'W') ? 'B' : 'W';
            }
            repaintColor = (repaintColor == 'W') ? 'B' : 'W';
        }

        return repaintCount;
    }
}
