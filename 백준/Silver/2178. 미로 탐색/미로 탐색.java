import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] board;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	
	static int bfs() {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(0, 0));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==1) {
					board[nx][ny] = board[current.x][current.y] + 1;
					queue.add(new Point(nx, ny));
				}
			}
		}
		return board[N-1][M-1];
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
		}
		
		System.out.println(bfs());
	}
}

class Point{
	int x, y;
		
	public Point(int x, int y) {
		this.x = x;
		this.y =y;
	}
}
