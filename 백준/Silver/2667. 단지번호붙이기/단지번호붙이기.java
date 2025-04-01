import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static int dfs(int i, int j) {
        int count = 1;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j));
        visited[i][j] = true;

        while (!stack.isEmpty()) {
            Point cur = stack.pop();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == 1) {
                    stack.push(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count ++;

                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        ArrayList<Integer> groupList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    groupList.add(dfs(i, j));
                }
            }
        }

        System.out.println(groupList.size());

        Collections.sort(groupList);

        for (Integer integer : groupList) {
            System.out.println(integer);
        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}