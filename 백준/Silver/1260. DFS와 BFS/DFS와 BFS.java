import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	private static void dfs(int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			
			if(!visited[node]) {
				visited[node] = true;
				sb.append(node + " ");
				for(int i = graph.length-1; i > 0; i--) {
					if(graph[node][i] == 1 && !visited[i]) {
						stack.push(i);
					}  // if
				}  // for
			}  // if
		} // while
	} // dfs
	
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node + " ");
			for(int i = 1; i <= graph.length-1; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				} // if
			} // for
		} // while
	} // bfs
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		dfs(V);
		
		sb.append("\n");
		
		visited = new boolean[N+1];
		
		bfs(V);

		System.out.println(sb);
	}

}
