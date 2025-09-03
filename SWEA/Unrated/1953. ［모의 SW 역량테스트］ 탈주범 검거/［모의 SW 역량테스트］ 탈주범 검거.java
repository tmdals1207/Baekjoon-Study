import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, R, C, L;
    static int[][] board;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int[] OPP = {1, 0, 3, 2};
    static final int[][] TYPE_DIRS = {
            {},
            {0, 1, 2, 3},
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {1, 2},
            {0, 2}
    };

    static boolean allows(int type, int dir) {

        for (int d : TYPE_DIRS[type]) if (d == dir) {

            return true;
        }

        return false;
    }

    static int bfs() {

        if (board[R][C] == 0) {

            return 0;
        }

        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int time = 1;
        int answer = 1;

        visited[R][C] = true;
        queue.add(new int[]{R, C});

        while (!queue.isEmpty() && time < L) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int curType = board[x][y];

                if (curType == 0) {
                    continue;
                }

                for (int d : TYPE_DIRS[curType]) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        int nxtType = board[nx][ny];

                        if (nxtType == 0) {
                            continue;
                        }

                        if (!allows(nxtType, OPP[d])) {
                            continue;
                        }

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        answer++;
                    }
                }
            }
            time++;
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            board = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(tc).append(' ').append(bfs()).append('\n');
        }
        
        System.out.println(sb);
    }
}
