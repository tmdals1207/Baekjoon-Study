import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(maze, n, m);
        System.out.println(result);
    }

    private static int bfs(int[][] maze, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.add(new Point(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[current.x][current.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
