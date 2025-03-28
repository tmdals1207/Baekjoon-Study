import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int groupCount = 0;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    
    
    static boolean dfs(int x, int y, int group) {
        visited[x][y] = group;

        int dir = board[x][y];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (visited[nx][ny] == 0) {
            return dfs(nx, ny, group);
        } else if (visited[nx][ny] == group) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);

                if (c == 'U') board[i][j] = 0;
                else if (c == 'R') board[i][j] = 1;
                else if (c == 'L') board[i][j] = 2;
                else if (c == 'D') board[i][j] = 3;
            }
        }

        int groupNumber = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    if (dfs(i, j, groupNumber)) {
                        groupCount++;
                    }
                    groupNumber++;
                }
            }
        }

        System.out.println(groupCount);
    }
}