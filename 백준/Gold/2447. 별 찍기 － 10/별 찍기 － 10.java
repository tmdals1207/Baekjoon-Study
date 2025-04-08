import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;


    static void star(int x, int y, int size, boolean isMid) {
        if (isMid) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        if (size == 1) return;

        int newSize = size / 3;
        int cnt = 1;

        for (int i = x; i < x+size; i+=newSize) {
            for (int j = y; j < y+size; j+=newSize) {
                star(i, j, newSize, cnt==5);
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '*';
            }
        }

        star(0, 0, N, false);

        for (char[] row : board) {
            System.out.println(row);
        }
    }
}