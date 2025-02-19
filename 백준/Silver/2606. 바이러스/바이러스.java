import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int pc, pair;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	private static int dfs(int n) {
		visited[n] = true;
		int count = 1;
		for (int next : graph.get(n)) {
            if (!visited[next]) {
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
		graph = new ArrayList<>();
        
        for (int i = 0; i <= pc; i++) {
            graph.add(new ArrayList<>());
        }
		
		for(int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
            graph.get(b).add(a);
		}
		
		visited = new boolean[pc + 1];
		System.out.print(dfs(1) - 1);
	}

}
