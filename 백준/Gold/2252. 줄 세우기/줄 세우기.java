import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // N : 노드의 수. M : 간선의 수.
	static int inDegree[]; // inDegree[3]==2; --> 3번 노드는 출력 순서가 0, 1, 2에서 2에 위치이다.
	static List<Integer>[] g; // g[1]==3; --> 1번 노드가 3번 노드의 앞에 위치한다.
	
	
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for(int nxt : g[current]){
				if(--inDegree[nxt]==0) queue.offer(nxt);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N+1];
		inDegree=new int[N+1];

		for(int i=1; i<N+1; i++) {
			g[i]=new ArrayList<>();
		} 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			inDegree[b]++;
		}
		
		bfs();
		
	}
}