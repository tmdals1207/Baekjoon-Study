import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++){
            int horizontal = scanner.nextInt();
            int vertical = scanner.nextInt();
            int cabbage = scanner.nextInt();

            int[][] board = new int[horizontal][vertical];
            boolean[][] visited = new boolean[horizontal][vertical];
            int larva = 0;

            for (int j = 0; j < cabbage; j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                board[x][y] = 1;
            }

            for (int a= 0 ; a < horizontal; a++){
                for (int b= 0; b < vertical; b++){
                    if(!visited[a][b] && board[a][b] == 1){
                        bfs(board, visited, horizontal, vertical, a, b);
                        larva++;
                    }
                }
            }
            System.out.println(larva);
        }
    }

    private static void bfs(int[][] board, boolean[][] visited, int horizontal, int vertical, int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int cabbage = board[startX][startY];
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && nx < horizontal && ny >= 0 && ny < vertical && !visited[nx][ny] && board[nx][ny] == cabbage) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}