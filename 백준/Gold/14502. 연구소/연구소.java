import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 풀이법.
	// 1. dfs로 벽 3개 세우기 함.
	// 2. 벽 3개 세우면 dfs 돌리고 안전 영역 크기 저장한 다음에 백트래킹함
	// 3. 해결ㅋ
	
	static int N, M, max;
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	
	static void infectionBfs(int[][] tmap) {
		int[][] map = new int[N][M];
	    for (int i = 0; i < N; i++) {
	        System.arraycopy(tmap[i], 0, map[i], 0, M);
	    }
		Queue<Point> queue = new LinkedList<Point>();
		
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (map[i][j] == 2) {
	                queue.add(new Point(i, j));
	            }
	        }
	    }
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = current.x+dx[i];
				int ny = current.y+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
					map[nx][ny] = 2;
					queue.add(new Point(nx, ny));
				}
			}
		}
		
		int safeZone = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (map[i][j] == 0) {
	                safeZone++;
	            }
	        }
	    }
	    max = Math.max(max, safeZone);
		
	}
	
	static void wallDfs (int x, int y, int cnt, int[][] map) {
		if(cnt == 3) {
			infectionBfs(map);
			return;
		}
		
		for (int i = x; i < N; i++) {
			for (int j = (i == x ? y : 0); j < M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					wallDfs(i, j+1, cnt+1, map);
					map[i][j]=0;
				}
			}
		}
		
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

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}