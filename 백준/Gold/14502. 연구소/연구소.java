import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, max;
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	
	static void wallDfs(int i, int j, int cnt, int[][] map) {
		
		if (cnt == 3) {
			infectionBfs(map);
			return;
		}
		
		for (int x = i; x < N; x++) {
			for (int y = (x == i ? j : 0); y < M; y++) {
				if(map[x][y]==0) {
					map[x][y] = 1;
					wallDfs(x, y+1, cnt+1, map);
					map[x][y]=0;
				}
			}
		}
		
	}

	private static void infectionBfs(int[][] map) {
		Queue<Point> queue = new LinkedList<Point>();
		int[][] newMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
	        System.arraycopy(map[i], 0, newMap[i], 0, M);
	    }
		
		for (int a = 0; a < N; a++) {
			for (int b = 0; b <M; b++) {
				if(newMap[a][b]==2) {
					queue.add(new Point(a, b));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && newMap[nx][ny]==0) {
					newMap[nx][ny] = 2;
					queue.add(new Point(nx, ny));
				}
			}
		}
		int safeZone = 0;
		for (int k = 0; k < N; k++) {
			for (int j = 0; j < M; j++) {
				if(newMap[k][j]==0) {
					safeZone++;
				}
			}
		}
		max = Math.max(max, safeZone);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wallDfs(0, 0, 0, map);
		
		System.out.println(max);

	}
public static class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
    
}