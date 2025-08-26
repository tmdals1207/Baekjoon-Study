import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] cheese;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static void bfs(int i, int j, int day, boolean[][] visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (0 <= nx && nx < N && 0 <= ny && ny < N
                        && !visited[nx][ny]
                        && cheese[nx][ny] > day) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int tcIdx = 1; tcIdx <= tc; tcIdx++) {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];

            int maxTaste = 0;
            boolean[] present = new boolean[101];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    cheese[j][k] = Integer.parseInt(st.nextToken());
                    int v = cheese[j][k];
                    present[v] = true;
                    if (v > maxTaste) maxTaste = v;
                }
            }

            int answer = 0;

            for (int d = 0; d <= maxTaste; d++) {
                if (d != 0 && !present[d]) continue;

                boolean[][] visited = new boolean[N][N];
                int cnt = 0;

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (!visited[x][y] && cheese[x][y] > d) {
                            bfs(x, y, d, visited);
                            cnt++;
                        }
                    }
                }
                answer = Math.max(answer, cnt);
            }
            sb.append('#').append(tcIdx).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}