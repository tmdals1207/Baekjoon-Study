import java.io.*;
import java.util.*;

public class Main {	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int N;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					pq.offer(bfs(i, j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	}

	static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		v[i][j] = true;
		q.offer(new int[]{i, j});

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];

				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && map[ni][nj] == 1) {
					cnt++;
					v[ni][nj] = true;
					q.offer(new int[]{ni, nj});
				}
			}
		}
		return cnt;
	}
}