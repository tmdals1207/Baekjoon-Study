import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
    static int n, m;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
    
    private static int bfs(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1) {
                    maps[nx][ny] = maps[current.x][current.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }   
        }
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
    
    public static class Point{
		int x, y;
		
		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
}