import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int inDegree[];
	static List<Integer>[] g;
	static BufferedWriter bw;

	
	static void bfs() throws IOException {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			bw.write(current + " ");
			
			for(int nxt : g[current]){
				if(--inDegree[nxt]==0) queue.offer(nxt);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
		
		bw.close();
	}
}