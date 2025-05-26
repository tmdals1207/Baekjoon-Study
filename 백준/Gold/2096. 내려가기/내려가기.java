import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;

    static void down() {
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];

        maxDp[0][0] = board[0][0];
        maxDp[0][1] = board[0][1];
        maxDp[0][2] = board[0][2];
        minDp[0][0] = board[0][0];
        minDp[0][1] = board[0][1];
        minDp[0][2] = board[0][2];

        for (int i = 1; i < N; i++) {
            maxDp[i][0] = board[i][0] + Math.max(maxDp[i-1][0], maxDp[i-1][1]);
            maxDp[i][1] = board[i][1] + Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]);
            maxDp[i][2] = board[i][2] + Math.max(maxDp[i-1][1], maxDp[i-1][2]);

            minDp[i][0] = board[i][0] + Math.min(minDp[i-1][0], minDp[i-1][1]);
            minDp[i][1] = board[i][1] + Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]);
            minDp[i][2] = board[i][2] + Math.min(minDp[i-1][1], minDp[i-1][2]);
        }

        int max = Math.max(Math.max(maxDp[N-1][0], maxDp[N-1][1]), maxDp[N-1][2]);
        int min = Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]);

        System.out.println(max + " " + min);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        down();

    }
}