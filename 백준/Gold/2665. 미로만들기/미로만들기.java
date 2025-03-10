import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] board, cnt;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	static void bfs() {
		Deque<Point> queue = new ArrayDeque<>();
		cnt = new int[n][n];
		
		for (int i = 0; i < n; i++) {
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }
		
		cnt[0][0] = 0;
		
		queue.add(new Point(0,0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					int cost = (board[nx][ny] == 0) ? 1 : 0;
					
					if(cnt[nx][ny] > cnt[cur.x][cur.y]+cost) {
						cnt[nx][ny] = cnt[cur.x][cur.y]+cost;
						
						if (cost==0) {
							queue.addLast(new Point(nx,ny));
						}
						else {
							queue.addFirst(new Point(nx,ny));
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
    	n = Integer.parseInt(st.nextToken());
    	board = new int[n][n];

    	for (int i = 0; i < n; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < n; j++) {
    			board[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	bfs();
    	
    	System.out.println(cnt[n-1][n-1]);
	}
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}