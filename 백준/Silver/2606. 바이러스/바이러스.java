import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int pc, pair;
	static int[][] graph;
	static boolean[] visited;
	
	private static int dfs(int n) {
		visited[n] = true;
		int count = 1;
		for (int next = 1; next <= pc; next++) {
			if(!visited[next] && graph[n][next] == 1) {
				count += dfs(next);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		pc = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		graph = new int[pc+1][pc+1];
		
		for(int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		visited = new boolean[pc + 1];
		System.out.print(dfs(1) - 1);
	}
}