import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int[][] board;
    static Set<String> set;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int depth , StringBuilder answer) {

        if (depth  == 7) {
            set.add(answer.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                answer.append(board[nx][ny]);
                dfs(nx, ny, depth + 1, answer);
                answer.deleteCharAt(answer.length() - 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            board = new int[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    StringBuilder answer = new StringBuilder();
                    answer.append(board[x][y]);
                    dfs(x, y, 1, answer);
                }
            }

            sb.append('#').append(tc).append(' ').append(set.size()).append('\n');
        }
        System.out.println(sb);
    }
}
